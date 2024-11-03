package com.gaurish.BankIt.Controllers;

import com.gaurish.BankIt.DTO.*;
import com.gaurish.BankIt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankit")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public BankResponse createAccount(@RequestBody UserDTO userDTO){
       return userService.createAccount(userDTO);
    }
    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

    @PostMapping("/credit")
    public BankResponse creditBalance(@RequestBody CreditDebitRequest request){
        return userService.creditAmount(request);
    }

    @PostMapping("/debit")
    public BankResponse debitBalance(@RequestBody CreditDebitRequest request){
        return userService.debitAmount(request);
    }

    @PostMapping("/transfer")
    public BankResponse transferBalance(@RequestBody Transfer request){
        return userService.transferAmount(request);
    }
}
