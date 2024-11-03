package com.gaurish.BankIt.Services;

import com.gaurish.BankIt.DTO.*;
import com.gaurish.BankIt.Entity.AccountNumberCounter;
import com.gaurish.BankIt.Entity.User;
import com.gaurish.BankIt.Repository.AccountNumberRepository;
import com.gaurish.BankIt.Repository.UserRepository;
import com.gaurish.BankIt.Utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountNumberRepository accountNumberRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public String generateUniqueAccountNumber() {
        if(accountNumberRepository.findAll().isEmpty()){
            accountNumberRepository.save(AccountNumberCounter
                    .builder()
                    .counter(1L)
                    .prevYear(Year.of(2023))
                    .build());
        }
        List<AccountNumberCounter> lst = accountNumberRepository.findAll();
        Year currYear = Year.now();
        Year prevYear = lst.get(0).getPrevYear();
        Long counter = lst.get(0).getCounter();
        // counter value  from data base
        if(!currYear.equals(prevYear)){
            lst.get(0).setCounter(1L);
            lst.get(0).setPrevYear(currYear);
            accountNumberRepository.save(lst.get(0));
        }

        String eightDigit = String.format("%08d", counter++);
        lst.get(0).setCounter(counter);
        accountNumberRepository.save(lst.get(0));
        return new StringBuilder(String.valueOf(currYear)).append(eightDigit).toString();

    }

    @Override
    public BankResponse createAccount(UserDTO userDTO) {
        if(userRepository.existsByEmailOrPhoneNumber(userDTO.getEmail(), userDTO.getPhoneNumber())){
           return BankResponse.builder()
                    .responseCode("001")
                    .responseMessage("Account Already Exists with same Email or Phone Number!!")
                    .accountInfo(null)
                    .build();
        }

        User newUser = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .otherName(userDTO.getOtherName())
                .gender(userDTO.getGender())
                .address(userDTO.getAddress())
                .stateOfOrigin(userDTO.getStateOfOrigin())
                .accountNumber(generateUniqueAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .alternativePhoneNumber(userDTO.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();

        EmailDetails emailDetails = EmailDetails
                .builder()
                .recipients(newUser.getEmail())
                .subject("Account Created Successfully - BankIt")
                .messageBody(AccountUtils.createWelcomeEmail(newUser))
                .build();

        emailService.sendEmailAlert(emailDetails);
        User saveUser = userRepository.save(newUser);

        return BankResponse.builder()
                .responseCode("002")
                .responseMessage("Account Successfully Created !!")
                .accountInfo(AccountInfo.builder()
                        .accountHolderName(saveUser.getFirstName() + " " + saveUser.getLastName())
                        .accountBalance(saveUser.getAccountBalance())
                        .accountNumber(saveUser.getAccountNumber())
                        .build())
                .build();
    }

    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request) {
        if(!userRepository.existsByAccountNumber(request.getAccountNumber())){
            return AccountUtils.Account_Not_Found();
        }

        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        return BankResponse.builder()
                .responseCode("002")
                .responseMessage("Account found Successfully!!")
                .accountInfo(AccountInfo.builder()
                                .accountBalance(foundUser.getAccountBalance())
                                .accountNumber(foundUser.getAccountNumber())
                                .accountHolderName(foundUser.getFirstName() + " " + foundUser.getLastName())
                                .build())
                .build();
    }

    @Override
    public String nameEnquiry(EnquiryRequest request) {
        if(!userRepository.existsByAccountNumber(request.getAccountNumber())){
            return "Account Not Exist!!";
        }

        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        return foundUser.getFirstName() + " " + foundUser.getLastName() + " ("+foundUser.getOtherName()+")";
    }

    @Override
    public BankResponse creditAmount(CreditDebitRequest request) {
        if (!userRepository.existsByAccountNumber(request.getAccountNumber())) {
            return AccountUtils.Account_Not_Found();
        }

        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        foundUser.setAccountBalance(foundUser.getAccountBalance().add(request.getAmount()));

        EmailDetails emailDetails = EmailDetails
                .builder()
                .recipients(foundUser.getEmail())
                .subject("Amount Credited Successfully - BankIt")
                .messageBody(AccountUtils.creditEmail(foundUser, request.getAmount()))
                .build();

        emailService.sendEmailAlert(emailDetails);
        userRepository.save(foundUser);
        return BankResponse.builder()
                    .responseCode("002")
                    .responseMessage("Account found Successfully!!")
                    .accountInfo(AccountInfo.builder()
                            .accountBalance(foundUser.getAccountBalance())
                            .accountNumber(foundUser.getAccountNumber())
                            .accountHolderName(foundUser.getFirstName() + " " + foundUser.getLastName())
                            .build())
                    .build();
    }

    @Override
    public BankResponse debitAmount(CreditDebitRequest request) {
        if (!userRepository.existsByAccountNumber(request.getAccountNumber())) {
            return AccountUtils.Account_Not_Found();
        }

        User foundUser = userRepository.findByAccountNumber(request.getAccountNumber());
        if(foundUser.getAccountBalance().compareTo(request.getAmount()) == -1){
            return BankResponse.builder().responseCode("001").responseMessage("Insufficient Amount")
                    .accountInfo(null).build();
        }

        foundUser.setAccountBalance(foundUser.getAccountBalance().subtract(request.getAmount()));
        EmailDetails emailDetails = EmailDetails
                .builder()
                .recipients(foundUser.getEmail())
                .subject("Amount Debited Successfully - BankIt")
                .messageBody(AccountUtils.debitEmail(foundUser, request.getAmount()))
                .build();

        emailService.sendEmailAlert(emailDetails);
        userRepository.save(foundUser);
        return BankResponse.builder()
                .responseCode("002")
                .responseMessage("Account found Successfully!!")
                .accountInfo(AccountInfo.builder()
                        .accountBalance(foundUser.getAccountBalance())
                        .accountNumber(foundUser.getAccountNumber())
                        .accountHolderName(foundUser.getFirstName() + " " + foundUser.getLastName())
                        .build())
                .build();
    }

    @Override
    public BankResponse transferAmount(Transfer request) {
        if (!userRepository.existsByAccountNumber(request.getSourceAccount())) {
            return BankResponse.builder().responseCode("001").responseMessage("Source Account Not Exist !")
                    .accountInfo(null).build();
        }
        if (!userRepository.existsByAccountNumber(request.getDestinationAccount())) {
            return BankResponse.builder().responseCode("001").responseMessage("Destination Account Not Exist !")
                    .accountInfo(null).build();
        }

        BankResponse response = debitAmount(CreditDebitRequest
                .builder()
                .accountNumber(request.getSourceAccount())
                .amount(request.getAmount())
                .build());
        if("001".equals(response.getResponseCode())){
            return response;
        }

        response = creditAmount(CreditDebitRequest
                .builder()
                .accountNumber(request.getDestinationAccount())
                .amount(request.getAmount())
                .build());

        return response;
    }
}
