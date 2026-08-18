package com.xworkz.hydro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class FeedbackDTO implements Serializable {

    private String email;
    private String name;
    private String mobile;
    private String comment;

}
