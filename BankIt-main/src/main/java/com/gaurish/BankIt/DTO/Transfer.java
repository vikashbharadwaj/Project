package com.gaurish.BankIt.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Transfer {
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;
}
