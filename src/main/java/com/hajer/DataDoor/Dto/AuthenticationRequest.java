package com.hajer.DataDoor.Dto;


import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
