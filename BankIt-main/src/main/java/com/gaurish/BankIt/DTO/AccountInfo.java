package com.gaurish.BankIt.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
public class AccountInfo {
    private String accountHolderName;
    private BigDecimal accountBalance;
    private String accountNumber;
//    private AccountType accountType;
}
