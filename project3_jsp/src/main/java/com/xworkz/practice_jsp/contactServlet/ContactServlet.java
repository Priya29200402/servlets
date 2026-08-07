package com.xworkz.practice_jsp.contactServlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String message = request.getParameter("message");

        RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");

        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("error", "Name is required.");
            dispatcher.forward(request, response);
            return;
        }

        if (!Pattern.matches("[A-Za-z ]{3,30}", name)) {
            request.setAttribute("error", "Enter a valid name.");
            dispatcher.forward(request, response);
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            request.setAttribute("error", "Email is required.");
            dispatcher.forward(request, response);
            return;
        }

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            request.setAttribute("error", "Invalid email address.");
            dispatcher.forward(request, response);
            return;
        }

        if (mobile == null || mobile.trim().isEmpty()) {
            request.setAttribute("error", "Mobile number is required.");
            dispatcher.forward(request, response);
            return;
        }

        if (!Pattern.matches("[6-9][0-9]{9}", mobile)) {
            request.setAttribute("error", "Enter a valid 10-digit mobile number.");
            dispatcher.forward(request, response);
            return;
        }

        if (message == null || message.trim().isEmpty()) {
            request.setAttribute("error", "Message is required.");
            dispatcher.forward(request, response);
            return;
        }

        if (message.length() < 10) {
            request.setAttribute("error", "Message should contain at least 10 characters.");
            dispatcher.forward(request, response);
            return;
        }
        request.setAttribute("message", name + ", your contact was sent successfully.");
        dispatcher.forward(request, response);
    }

}
