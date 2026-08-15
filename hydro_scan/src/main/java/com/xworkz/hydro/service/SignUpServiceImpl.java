package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.SignUpDTO;

public class SignUpServiceImpl implements  SignUpService {

    @Override
    public boolean validateAndSave(SignUpDTO signUpDTO) {
        System.out.println("Running validateAndSave in SignUpServiceImpl");
        return true;
    }
}
