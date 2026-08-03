package com.xworkz.hotelBooking;

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
import java.util.regex.Pattern;

@WebServlet("/hotel")
public class HotelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String guestName = req.getParameter("guestName");
        String hotelName = req.getParameter("hotelName");
        String roomType = req.getParameter("roomType");
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        String guests = req.getParameter("guests");
        String contact = req.getParameter("contact");

        System.out.println("Guest Name: " + guestName);
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Check-In Date: " + checkIn);
        System.out.println("Check-Out Date: " + checkOut);
        System.out.println("Guests: " + guests);
        System.out.println("Contact Number: " + contact);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        System.out.println("======Validating guest name=======");
        if (guestName == null || guestName.trim().length() < 3) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Guest Name must contain at least 3 characters</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating hotel name=======");
        if (hotelName == null || hotelName.trim().length() < 3) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Hotel Name must contain at least 3 characters</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating room type=======");
        String[] validRooms = {"Single", "Double", "Deluxe", "Suite"};
        boolean validRoom = false;

        for (String room : validRooms) {
            if (room.equalsIgnoreCase(roomType)) {
                validRoom = true;
                break;
            }
        }

        if (!validRoom) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Room Type</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating check-in date=======");
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;

        try {
            checkInDate = LocalDate.parse(checkIn, DateTimeFormatter.ISO_LOCAL_DATE);

            if (checkInDate.isBefore(LocalDate.now())) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Check-In Date cannot be in the past</p>");
                out.println("<a href='/static/hotel.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (DateTimeParseException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Check-In Date</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating check-out date=======");
        try {
            checkOutDate = LocalDate.parse(checkOut, DateTimeFormatter.ISO_LOCAL_DATE);

            if (checkInDate != null && !checkOutDate.isAfter(checkInDate)) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Check-Out Date must be after Check-In Date</p>");
                out.println("<a href='/static/hotel.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (DateTimeParseException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Check-Out Date</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating number of guests=======");
        try {
            int totalGuests = Integer.parseInt(guests);

            if (totalGuests <= 0) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Number of Guests must be greater than 0</p>");
                out.println("<a href='/static/hotel.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Number of Guests</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating contact number=======");
        if (contact == null || !Pattern.matches("[6-9][0-9]{9}", contact)) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Contact Number</p>");
            out.println("<a href='/static/hotel.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h1>Hotel Booking Successful</h1>");
        out.println("</body></html>");
    }
}