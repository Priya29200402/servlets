package com.xworkz.eventRegistration;

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
        PrintWriter out = resp.getWriter();

        System.out.println("======Validating event date=======");
        try {
            LocalDate date = LocalDate.parse(eventDate, DateTimeFormatter.ISO_LOCAL_DATE);

            if (!date.isAfter(LocalDate.now())) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Event Date must be a future date</p>");
                out.println("<a href='/static/event.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (DateTimeParseException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Event Date</p>");
            out.println("<a href='/static/event.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating capacity=======");
        try {
            int cap = Integer.parseInt(capacity);

            if (cap <= 0) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Capacity must be greater than 0</p>");
                out.println("<a href='/static/event.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Capacity</p>");
            out.println("<a href='/static/event.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating registration fee=======");
        try {
            double registrationFee = Double.parseDouble(fee);

            if (registrationFee < 0) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Registration Fee cannot be negative</p>");
                out.println("<a href='/static/event.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Registration Fee</p>");
            out.println("<a href='/static/event.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h1>Event Registered Successfully</h1>");
        out.println("</body></html>");
    }
}