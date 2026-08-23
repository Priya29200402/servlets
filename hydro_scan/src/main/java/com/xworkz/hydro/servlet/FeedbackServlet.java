package com.xworkz.hydro.servlet;

import com.xworkz.hydro.dto.FeedbackDTO;
import com.xworkz.hydro.service.FeedbackService;
import com.xworkz.hydro.service.FeedbackServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/feedback", loadOnStartup = 1)
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Running doPost method in FeedbackServlet");

        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String comment = request.getParameter("comment");
        int feedbackId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);

        FeedbackDTO feedbackDTO = new FeedbackDTO(feedbackId, userId, email, name, mobile, comment);
        System.out.println("Feedback DTO:" + feedbackDTO);

        FeedbackService feedbackService = new FeedbackServiceImpl();
        boolean saved = feedbackService.validateAndSave(feedbackDTO);
        System.out.println("Feedback saved:" + saved);


        HttpSession session=request.getSession();
        session.setAttribute("session", "Priya");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("Feedback.jsp");
        requestDispatcher.forward(request, response);


        RequestDispatcher dispatcher = request.getRequestDispatcher("Feedback.jsp");
        request.setAttribute("feedback", "Feedback Submitted Successfully");
        dispatcher.forward(request, response);
    }
}
