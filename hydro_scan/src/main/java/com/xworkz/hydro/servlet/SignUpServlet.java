package com.xworkz.hydro.servlet;

import com.xworkz.hydro.dto.SignUpDTO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns ="/signup",loadOnStartup = 1)
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        System.out.println("Running doPost in SignUpServlet");
        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        SignUpDTO signUpDTO = new SignUpDTO(userID, email, password, confirmPassword);
        System.out.println("SignUp DTO:"+ signUpDTO);

        request.setAttribute("signUpDTO", "Signup Successful");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignUp.jsp");
        requestDispatcher.forward(request, response);
    }
}
