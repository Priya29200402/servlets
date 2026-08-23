package com.xworkz.hydro.dao;

import com.xworkz.hydro.entity.FeedbackEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAOImpl implements FeedbackDAO {
    @Override
    public boolean save(FeedbackEntity feedbackEntity) {
        System.out.println("Running save in FeedbackDAOImpl");
       System.out.println("FeedbackEntity:" + feedbackEntity);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

       String sql = "INSERT INTO feedback1(feedbackId, userId, email, name, mobile, comment) VALUES (?, ?, ?, ?, ?, ?)";

       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/priyadb", "root", "Priya@29");
            PreparedStatement statement = connection.prepareStatement(sql)) {

           statement.setInt(1, feedbackEntity.getFeedbackId());
           statement.setString(2, feedbackEntity.getUserId());
           statement.setString(3, feedbackEntity.getEmail());
           statement.setString(4, feedbackEntity.getName());
           statement.setString(5, feedbackEntity.getMobile());
           statement.setString(6, feedbackEntity.getComment());

           int rows = statement.executeUpdate();
           System.out.println("Rows inserted: " + rows);
           return rows > 0;

       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
    }
}