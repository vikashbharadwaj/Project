package com.gaurish.BankIt.Utils;

import com.gaurish.BankIt.DTO.BankResponse;
import com.gaurish.BankIt.Entity.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountUtils {
 public static String createWelcomeEmail(User user) {
  return String.format(
          "Dear " + user.getFirstName() + ",\n\n" +
                  "Congratulations !! \n\nYour account with BankIt has been successfully created.\n\n" +
                  "We are thrilled to have you as a part of the BankIt family, and we want to express our sincere gratitude for choosing us as your trusted banking partner.\n\n" +
                  "Below are the details of your new account:\n\n" +
                  "----------------------------------------------------------------\n" +
                  "Account Holder Name    :  " + user.getFirstName() + " " + user.getLastName() + " \n" +
                  "Account Number         :  " + user.getAccountNumber() + " \n" +
                  "Account Balance        :  Rs " + user.getAccountBalance() + "\n" +
                  "Registered Email       :  " + user.getEmail() + " \n" +
                  "Registered Phone       :  " + user.getPhoneNumber() + " \n" +
                  "---------------------------------------------------------------\n\n"  +
                  "Thank you once again for choosing BankIt. \n\n" +
                  "\n"+
                  "Thanks & Regards,\n" +
                  "Gaurish - BankIt Team");
 }

 public static String creditEmail(User user, BigDecimal creditedAmount) {
  return String.format(
                  "Dear " + user.getFirstName() + ",\n\n" +
                  "We are pleased to inform you that an amount of Rs " + creditedAmount +
                  " has been successfully credited to your BankIt account.\n\n" +
                  "Please find the details of the transaction below:\n\n" +
                  "---------------------------------------------------------------------\n" +
                  "Account Holder Name    :  " + user.getFirstName() + " " + user.getLastName() + " \n" +
                  "Account Number            :  " + user.getAccountNumber() + " \n" +
                  "Credited Amount            :  Rs " + creditedAmount + " \n" +
                  "New Account Balance     :  Rs " + user.getAccountBalance() + " \n" +
                  "Transaction Date            :  " + LocalDateTime.now() + " \n" +
                  "--------------------------------------------------------------------\n\n" +
                  "Thank you for banking with BankIt.\n\n" +
                  "If you have any questions, please do not hesitate to contact our support team.\n\n" +
                  "Thanks & Regards,\n" +
                  "Gaurish - BankIt Team"
  );
 }

 public static String debitEmail(User user, BigDecimal debitAmount) {
  return String.format(
          "Dear " + user.getFirstName() + ",\n\n" +
                  "We are informing you that an amount of Rs " + debitAmount +
                  " has been successfully debited to your BankIt account.\n\n" +
                  "Please find the details of the transaction below:\n\n" +
                  "---------------------------------------------------------------------\n" +
                  "Account Holder Name    :  " + user.getFirstName() + " " + user.getLastName() + " \n" +
                  "Account Number            :  " + user.getAccountNumber() + " \n" +
                  "Debited Amount            :  Rs " + debitAmount + " \n" +
                  "New Account Balance     :  Rs " + user.getAccountBalance() + " \n" +
                  "Transaction Date            :  " + LocalDateTime.now() + " \n" +
                  "--------------------------------------------------------------------\n\n" +
                  "Thank you for banking with BankIt.\n\n" +
                  "If you have any questions, please do not hesitate to contact our support team.\n\n" +
                  "Thanks & Regards,\n" +
                  "Gaurish - BankIt Team"
  );
 }
 public static BankResponse Account_Not_Found(){
  return BankResponse.builder()
          .responseCode("001")
          .responseMessage("Account Number Does Not Exist!!")
          .accountInfo(null)
          .build();
 }
}
