package com.gaurish.BankIt.Services;

import com.gaurish.BankIt.DTO.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
