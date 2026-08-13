package com.xworkz.hydro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SignUpDTO implements Serializable{
    private String userID;
    private String email;
    private String password;
    private String confirmPassword;
}
