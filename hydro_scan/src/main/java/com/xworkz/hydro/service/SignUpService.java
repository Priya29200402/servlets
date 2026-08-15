package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.SignUpDTO;

public interface SignUpService {
    boolean validateAndSave(SignUpDTO signUpDTO);
}
