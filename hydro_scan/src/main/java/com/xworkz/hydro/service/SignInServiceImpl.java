package com.xworkz.hydro.service;

import com.xworkz.hydro.dao.SignInDAO;
import com.xworkz.hydro.dao.SignInDAOImpl;
import com.xworkz.hydro.dto.SignInDTO;
import com.xworkz.hydro.entity.SignInEntity;

public class SignInServiceImpl implements  SignInService{
    @Override
    public boolean validateAndSave(SignInDTO signInDTO) {
        System.out.println("Running validateAndSave in SignInServiceImpl");

        if(signInDTO != null){
            System.out.println("Valid DTO we can send Data to DAO");
            SignInEntity signInEntity=new SignInEntity();
            signInEntity.setPassword(signInDTO.getPassword());
            signInEntity.setUserId(signInDTO.getUserId());

            SignInDAO signInDAO = new SignInDAOImpl();
            signInDAO.save(signInEntity);

        }
        return true;
    }
}
