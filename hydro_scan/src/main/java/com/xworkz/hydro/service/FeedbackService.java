package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.FeedbackDTO;

public interface FeedbackService {
    boolean validateAndSave(FeedbackDTO feedbackDTO);
}
