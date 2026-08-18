package com.xworkz.hydro.dao;

import com.xworkz.hydro.dto.FeedbackDTO;
import com.xworkz.hydro.entity.FeedbackEntity;

public interface FeedbackDAO {
    boolean save(FeedbackEntity feedbackEntity);
}
