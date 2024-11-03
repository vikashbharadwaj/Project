package com.gaurish.BankIt.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    @NonNull
    private String firstName;
    private String lastName;
    private String otherName;
}
