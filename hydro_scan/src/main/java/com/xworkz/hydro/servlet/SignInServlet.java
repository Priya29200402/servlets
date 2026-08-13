package com.xworkz.hydro.servlet;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import com.xworkz.hydro.dto.SignInDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin",loadOnStartup = 1)
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        System.out.println("Running doPost in SignInServlet");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        SignInDTO signInDTO = new SignInDTO(userId, password);
        System.out.println("SignIn DTO:"+ signInDTO);

        request.setAttribute("signIn", "Sign In Successful");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIn.jsp");
        requestDispatcher.forward(request, response);





    }



}
