package com.crud.Assigment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String id;
    @NotBlank(message = "Full Name is required")
    private String fullName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Mobile Number is required")
    private String mobileNumber;
    @NotBlank(message = "Password is required")
    private String password;
    private String dob;
}
