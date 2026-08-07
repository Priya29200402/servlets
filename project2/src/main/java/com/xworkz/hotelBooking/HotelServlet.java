package com.xworkz.hotelBooking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

@WebServlet("/hotel")
public class HotelServlet extends HttpServlet {

    private static final Pattern CONTACT_PATTERN = Pattern.compile("[6-9][0-9]{9}");

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
        PrintWriter writer = resp.getWriter();

        boolean valid = true;
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;

        // Guest name
        if (guestName == null || guestName.trim().length() < 3) {
            valid = false;
            writer.println("<h3 style='color:red'>Guest Name must contain at least 3 characters</h3>");
        }

        // Hotel name
        if (hotelName == null || hotelName.trim().length() < 3) {
            valid = false;
            writer.println("<h3 style='color:red'>Hotel Name must contain at least 3 characters</h3>");
        }

        // Room type
        String[] validRooms = {"Single", "Double", "Deluxe", "Suite"};
        boolean validRoom = false;
        for (String room : validRooms) {
            if (room.equalsIgnoreCase(roomType)) {
                validRoom = true;
                break;
            }
        }
        if (!validRoom) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Room Type</h3>");
        }

        // Check-in date
        try {
            checkInDate = LocalDate.parse(checkIn);
            if (checkInDate.isBefore(LocalDate.now())) {
                valid = false;
                writer.println("<h3 style='color:red'>Check-In Date cannot be in the past</h3>");
            }
        } catch (DateTimeParseException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Check-In Date</h3>");
        }

        // Check-out date
        try {
            checkOutDate = LocalDate.parse(checkOut);
            if (checkInDate != null && !checkOutDate.isAfter(checkInDate)) {
                valid = false;
                writer.println("<h3 style='color:red'>Check-Out Date must be after Check-In Date</h3>");
            }
        } catch (DateTimeParseException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Check-Out Date</h3>");
        }

        // Guests
        try {
            int totalGuests = Integer.parseInt(guests);
            if (totalGuests <= 0) {
                valid = false;
                writer.println("<h3 style='color:red'>Number of Guests must be greater than 0</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Number of Guests</h3>");
        }

        // Contact
        if (contact == null || !CONTACT_PATTERN.matcher(contact).matches()) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Contact Number</h3>");
        }

        if (valid) {
            writer.println("<html>");
            writer.println("<body style='font-family:Arial;text-align:center;background:#f4f4f4;'>");
            writer.println("<h1 style='color:green'>Hotel Booking Successful</h1>");
            writer.println("<h3>Guest Name : " + guestName + "</h3>");
            writer.println("<h3>Hotel Name : " + hotelName + "</h3>");
            writer.println("<h3>Room Type : " + roomType + "</h3>");
            writer.println("<h3>Check-In : " + checkIn + "</h3>");
            writer.println("<h3>Check-Out : " + checkOut + "</h3>");
            writer.println("<h3>Guests : " + guests + "</h3>");
            writer.println("<h3>Contact : " + contact + "</h3>");
            writer.println("<br>");
            writer.println("<a href='hotel.html'>");
            writer.println("<button>Book Another</button>");
            writer.println("</a>");
            writer.println("<br><br>");
            writer.println("<a href='index.html'>");
            writer.println("<button>Go to Home</button>");
            writer.println("</a>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            writer.println("<br>");
            writer.println("<a href='hotel.html'>");
            writer.println("<button>Go Back</button>");
            writer.println("</a>");
        }

        writer.close();
    }
}