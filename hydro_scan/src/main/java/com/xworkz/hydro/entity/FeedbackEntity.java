package com.xworkz.hydro.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackEntity {
    private int feedbackId;
    private String userId;
    private String email;
    private String name;
    private String mobile;
    private String comment;
}
