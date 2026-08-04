package com.xworkz.eventRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/event")
public class EventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String eventName = req.getParameter("eventName");
        String organizerName = req.getParameter("organizerName");
        String eventDate = req.getParameter("eventDate");
        String venue = req.getParameter("venue");
        String capacity = req.getParameter("capacity");
        String fee = req.getParameter("fee");

        System.out.println("Event Name: " + eventName);
        System.out.println("Organizer Name: " + organizerName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Venue: " + venue);
        System.out.println("Capacity: " + capacity);
        System.out.println("Fee: " + fee);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        boolean valid = true;

        // Event Date Validation (must be future)
        try {
            LocalDate date = LocalDate.parse(eventDate);
            if (!date.isAfter(LocalDate.now())) {
                valid = false;
                writer.println("<h3 style='color:red'>Event Date must be a future date</h3>");
            }
        } catch (DateTimeParseException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Event Date</h3>");
        }

        // Capacity Validation
        try {
            int cap = Integer.parseInt(capacity);
            if (cap <= 0) {
                valid = false;
                writer.println("<h3 style='color:red'>Capacity must be greater than 0</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Capacity</h3>");
        }

        // Fee Validation
        try {
            double registrationFee = Double.parseDouble(fee);
            if (registrationFee < 0) {
                valid = false;
                writer.println("<h3 style='color:red'>Registration Fee cannot be negative</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Registration Fee</h3>");
        }

        if (valid) {
            writer.println("<html>");
            writer.println("<body style='font-family:Arial;text-align:center;background:#f4f4f4;'>");
            writer.println("<h1 style='color:green'>Event Registered Successfully</h1>");
            writer.println("<h3>Event Name : " + eventName + "</h3>");
            writer.println("<h3>Organizer : " + organizerName + "</h3>");
            writer.println("<h3>Event Date : " + eventDate + "</h3>");
            writer.println("<h3>Venue : " + venue + "</h3>");
            writer.println("<h3>Capacity : " + capacity + "</h3>");
            writer.println("<h3>Fee : " + fee + "</h3>");
            writer.println("<br>");
            writer.println("<a href='event.html'>");
            writer.println("<button>Register Another Event</button>");
            writer.println("</a>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            writer.println("<br>");
            writer.println("<a href='event.html'>");
            writer.println("<button>Go Back</button>");
            writer.println("</a>");
        }

        writer.close();
    }
}