package com.xworkz.hydro.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/upload")

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String image = request.getParameter("image");
      String name = request.getParameter("name");

      HttpSession session = request.getSession();
      session.setAttribute("name", name);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("Upload.jsp");
      requestDispatcher.forward(request, response);
    }
}
