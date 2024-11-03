package com.gaurish.BankIt.Services;

import com.gaurish.BankIt.DTO.*;

public interface UserService {
    String generateUniqueAccountNumber();

    BankResponse createAccount(UserDTO userDTO);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
    BankResponse creditAmount(CreditDebitRequest request);
    BankResponse debitAmount(CreditDebitRequest request);
    BankResponse transferAmount(Transfer request);
}
