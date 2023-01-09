package com.workshop.BOALI.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
