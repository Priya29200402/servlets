package com.xworkz.hydro.dao;

import com.xworkz.hydro.entity.FeedbackEntity;

public class FeedbackDAOImpl implements  FeedbackDAO{
    @Override
    public boolean save(FeedbackEntity feedbackEntity) {
        System.out.println("Running save in FeedbackDAOImpl");
        System.out.println("Feedback Entity:"+feedbackEntity);
        return true;
    }
}
