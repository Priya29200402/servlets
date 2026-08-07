package com.xworkz.travelRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
        PrintWriter writer = resp.getWriter();

        boolean valid = true;
        LocalDate tDate = null;
        LocalDate rDate = null;

        // Travel date validation
        try {
            tDate = LocalDate.parse(travelDate);
        } catch (DateTimeParseException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Travel Date</h3>");
        }

        // Return date validation
        try {
            rDate = LocalDate.parse(returnDate);
            if (tDate != null && !rDate.isAfter(tDate)) {
                valid = false;
                writer.println("<h3 style='color:red'>Return Date must be after Travel Date</h3>");
            }
        } catch (DateTimeParseException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Return Date</h3>");
        }

        // Travelers validation
        int count = 0;
        try {
            count = Integer.parseInt(travelers);
            if (count <= 0) {
                valid = false;
                writer.println("<h3 style='color:red'>Traveler count must be greater than 0</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Traveler Count</h3>");
        }

        // Budget validation
        double amount = 0;
        try {
            amount = Double.parseDouble(budget);
            if (amount <= 0) {
                valid = false;
                writer.println("<h3 style='color:red'>Budget must be greater than 0</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Budget</h3>");
        }

        if (valid) {
            double perTraveler = (count > 0) ? amount / count : 0;
            writer.println("<html>");
            writer.println("<body style='font-family:Arial;text-align:center;background:#f4f4f4;'>");
            writer.println("<h1 style='color:green'>Trip Booked Successfully</h1>");
            writer.println("<h3>Destination : " + destination + "</h3>");
            writer.println("<h3>Travel Date : " + travelDate + "</h3>");
            writer.println("<h3>Return Date : " + returnDate + "</h3>");
            writer.println("<h3>Travelers : " + travelers + "</h3>");
            writer.println("<h3>Budget : " + budget + "</h3>");
            writer.println("<h3>Per Traveler : " + perTraveler + "</h3>");
            writer.println("<br>");
            writer.println("<a href='travel.html'>");
            writer.println("<button>Book Another Trip</button>");
            writer.println("</a>");
            writer.println("<br><br>");
            writer.println("<a href='index.html'>");
            writer.println("<button>Go to Home</button>");
            writer.println("</a>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            writer.println("<br>");
            writer.println("<a href='travel.html'>");
            writer.println("<button>Go Back</button>");
            writer.println("</a>");
        }

        writer.close();
    }
}