package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.SignInDTO;

public class SignInServiceImpl implements  SignInService{
    @Override
    public boolean validateAndSave(SignInDTO signInDTO) {
        System.out.println("Running validateAndSave in SignInServiceImpl");
        return true;
    }
}
