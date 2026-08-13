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

public class SignInDTO implements Serializable {
    private String userId;
    private String password;

}
