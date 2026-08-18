package com.xworkz.hydro.service;

import com.xworkz.hydro.dao.SignUpDAO;
import com.xworkz.hydro.dao.SignUpDAOImpl;
import com.xworkz.hydro.dto.SignUpDTO;
import com.xworkz.hydro.entity.SignUpEntity;

public class SignUpServiceImpl implements  SignUpService {

    @Override
    public boolean validateAndSave(SignUpDTO signUpDTO) {
        System.out.println("Running validateAndSave in SignUpServiceImpl");

        if(signUpDTO != null){
            System.out.println("SignUpDTO is not null, we can send Data to DAO");

            SignUpEntity signUpEntity=new SignUpEntity();
            signUpEntity.setPassword(signUpDTO.getPassword());
            signUpEntity.setEmail(signUpDTO.getEmail());
            signUpEntity.setUserID(signUpDTO.getUserID());
            signUpEntity.setConfirmPassword(signUpDTO.getConfirmPassword());

            SignUpDAO signUpDAO =new SignUpDAOImpl();
            signUpDAO.save(signUpEntity);

        }
        return true;
    }
}
