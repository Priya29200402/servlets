package com.xworkz.hydro.service;

import com.xworkz.hydro.dao.FeedbackDAO;
import com.xworkz.hydro.dao.FeedbackDAOImpl;
import com.xworkz.hydro.dto.FeedbackDTO;
import com.xworkz.hydro.entity.FeedbackEntity;

public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public boolean validateAndSave(FeedbackDTO feedbackDTO) {
        System.out.println("Running Validate and Save in FeedbackServiceImpl");

        if (feedbackDTO != null) {
            System.out.println("Valid DTO. We can send data to DAO.");

            FeedbackEntity feedbackEntity = new FeedbackEntity();
            feedbackEntity.setFeedbackId(feedbackDTO.getFeedbackId());
            feedbackEntity.setUserId(feedbackDTO.getUserId());
            feedbackEntity.setName(feedbackDTO.getName());
            feedbackEntity.setEmail(feedbackDTO.getEmail());
            feedbackEntity.setComment(feedbackDTO.getComment());
            feedbackEntity.setMobile(feedbackDTO.getMobile());

            FeedbackDAO feedbackDAO = new FeedbackDAOImpl();
            return feedbackDAO.save(feedbackEntity);
        }
        return false;
    }
}
