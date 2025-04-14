package com.udemy.Udemyjpa.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {

    @JsonIgnore
    private long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
}
