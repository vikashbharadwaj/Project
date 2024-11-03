package com.gaurish.BankIt.DTO;

import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Data
@Builder
public class UserDTO {
    private String gender;
    private String address;
    private String firstName;
    private String lastName;
    private String otherName;
    private String stateOfOrigin;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    private String alternativePhoneNumber;
}
