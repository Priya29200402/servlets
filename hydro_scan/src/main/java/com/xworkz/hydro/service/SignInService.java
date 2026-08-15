package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.SignInDTO;

public interface SignInService {
    boolean validateAndSave(SignInDTO signInDTO);
}
