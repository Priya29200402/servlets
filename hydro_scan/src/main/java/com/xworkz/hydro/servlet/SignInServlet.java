package com.xworkz.hydro.servlet;

import com.xworkz.hydro.dto.SignInDTO;
import com.xworkz.hydro.service.SignInService;
import com.xworkz.hydro.service.SignInServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/signin",loadOnStartup = 1)
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Running doPost in SignInServlet");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        SignInDTO signInDTO = new SignInDTO(userId, password);
        System.out.println("SignIn DTO:"+ signInDTO);

        SignInService signInService = new SignInServiceImpl();
        boolean saved= signInService.validateAndSave(signInDTO);

        if(saved) {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("Home.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("userId",userId);
            requestDispatcher.forward(request,response);
        }else{
            RequestDispatcher dispatcher=request.getRequestDispatcher("Register.jsp");
            request.setAttribute("Fail Message","Your Signed In Failed");
            dispatcher.forward(request,response);

        }
    }
}
