package com.xworkz.hydro.dao;

import com.xworkz.hydro.entity.SignUpEntity;

public class SignUpDAOImpl implements  SignUpDAO{
    @Override
    public boolean save(SignUpEntity signUpEntity) {
        System.out.println("Running save in SignUpDAOImpl");
        System.out.println("SignUpEntity:"+signUpEntity);
        return true;
    }
}
