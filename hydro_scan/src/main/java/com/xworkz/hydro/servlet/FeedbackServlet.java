package com.xworkz.hydro.servlet;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import com.xworkz.hydro.dto.FeedbackDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/feedback",loadOnStartup = 1)
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Running doPost method in FeedbackServlet");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String comment = request.getParameter("comment");

        FeedbackDTO feedbackDTO = new FeedbackDTO(email, name, mobile, comment);
        System.out.println("Feedback DTO:"+feedbackDTO);

        request.setAttribute("feedback", "Feedback Submitted Successfully");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Feedback.jsp");
        requestDispatcher.forward(request, response);

    }

}
