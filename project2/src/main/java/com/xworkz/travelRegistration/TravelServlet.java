package com.xworkz.travelRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String destination = req.getParameter("destination");
        String travelDate = req.getParameter("travelDate");
        String returnDate = req.getParameter("returnDate");
        String travelers = req.getParameter("travelers");
        String budget = req.getParameter("budget");
        String transport = req.getParameter("transport");

        System.out.println("Destination: " + destination);
        System.out.println("Travel Date: " + travelDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Travelers: " + travelers);
        System.out.println("Budget: " + budget);
        System.out.println("Transport: " + transport);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        System.out.println("======Validating travel date=======");
        LocalDate tDate = null;
        LocalDate rDate = null;

        try {
            tDate = LocalDate.parse(travelDate, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Travel Date</p>");
            out.println("<a href='/static/travel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating return date=======");
        try {
            rDate = LocalDate.parse(returnDate, DateTimeFormatter.ISO_LOCAL_DATE);

            if (tDate != null && !rDate.isAfter(tDate)) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Return Date must be after Travel Date</p>");
                out.println("<a href='/static/travel.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (DateTimeParseException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Return Date</p>");
            out.println("<a href='/static/travel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating traveler count=======");
        int count = 0;
        try {
            count = Integer.parseInt(travelers);

            if (count <= 0) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Traveler count must be greater than 0</p>");
                out.println("<a href='/static/travel.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Traveler Count</p>");
            out.println("<a href='/static/travel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating budget=======");
        double amount = 0;
        try {
            amount = Double.parseDouble(budget);

            if (amount <= 0) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Budget must be greater than 0</p>");
                out.println("<a href='/static/travel.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Budget</p>");
            out.println("<a href='/static/travel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        double perTraveler = amount / count;

        out.println("<html><body>");
        out.println("<h1>Trip Booked Successfully</h1>");
        out.println("</body></html>");
    }
}