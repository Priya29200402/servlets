package com.xworkz.hydro.dao;

import com.xworkz.hydro.entity.SignInEntity;

public class SignInDAOImpl implements SignInDAO{
    @Override
    public boolean save(SignInEntity signInEntity) {
        System.out.println("Running save in SignInDAOImpl");
        System.out.println("SignInEntity:"+ signInEntity);
        return true;
    }
}
