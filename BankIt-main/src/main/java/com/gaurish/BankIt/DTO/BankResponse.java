package com.gaurish.BankIt.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankResponse {
  private String responseCode;
  private String responseMessage;
  private AccountInfo accountInfo;
}
