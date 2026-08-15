package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.FeedbackDTO;

public class FeedbackServiceImpl implements FeedbackService{
    @Override
    public boolean validateAndSave(FeedbackDTO feedbackDTO) {
        System.out.println("Running Validate and Save in FeedbackServiceImpl");
        return true;
    }
}
