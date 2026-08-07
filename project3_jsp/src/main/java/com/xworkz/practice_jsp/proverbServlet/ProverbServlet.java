package com.xworkz.practice_jsp.proverbServlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/proverb")
public class ProverbServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String proverb = request.getParameter("proverb");
        String city = request.getParameter("city");

        RequestDispatcher dispatcher = request.getRequestDispatcher("proverb.jsp");

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

        if (proverb == null || proverb.trim().isEmpty()) {
            request.setAttribute("error", "Proverb is required.");
            dispatcher.forward(request, response);
            return;
        }

        if (proverb.length() < 5) {
            request.setAttribute("error", "Proverb should contain at least 5 characters.");
            dispatcher.forward(request, response);
            return;
        }

        if (city == null || city.trim().isEmpty()) {
            request.setAttribute("error", "City is required.");
            dispatcher.forward(request, response);
            return;
        }

        if (!Pattern.matches("[A-Za-z ]{2,30}", city)) {
            request.setAttribute("error", "Enter a valid city name.");
            dispatcher.forward(request, response);
            return;
        }
        request.setAttribute("message", name +", your proverb was submitted successfully.");
        dispatcher.forward(request, response);
    }

}
