package com.xworkz.hydro.service;

import com.xworkz.hydro.dao.FeedbackDAO;
import com.xworkz.hydro.dao.FeedbackDAOImpl;
import com.xworkz.hydro.dto.FeedbackDTO;
import com.xworkz.hydro.entity.FeedbackEntity;

public class FeedbackServiceImpl implements FeedbackService{
    @Override
    public boolean validateAndSave(FeedbackDTO feedbackDTO) {
        System.out.println("Running Validate and Save in FeedbackServiceImpl");

        //Validate DTO
        if(feedbackDTO != null){
            System.out.println("Valid DTO We can send Data to DAO");
            //Conversion DTO-->Entity
            FeedbackEntity feedbackEntity=new FeedbackEntity();
            feedbackEntity.setName(feedbackDTO.getName());
            feedbackEntity.setEmail(feedbackDTO.getEmail());
            feedbackEntity.setComment(feedbackDTO.getComment());
            feedbackEntity.setMobile(feedbackDTO.getMobile());

            //Sending Entity to DAO

            FeedbackDAO feedbackDAO=new FeedbackDAOImpl();
            feedbackDAO.save(feedbackEntity);
        }
        return true;
    }

}
