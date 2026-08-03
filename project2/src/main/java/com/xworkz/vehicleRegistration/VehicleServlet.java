package com.xworkz.vehicleRegistration;

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

@WebServlet("/vehicle")

public class VehicleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String number=req.getParameter("number");
        String type=req.getParameter("type");
        String date=req.getParameter("date");
        String insurance=req.getParameter("insurance");
        String fuel=req.getParameter("fuel");

        System.out.println("Vehicle Name: " + name);
        System.out.println("Vehicle Number: " + number);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Registration Date: " + date);
        System.out.println("Insurance: " + insurance);
        System.out.println("Fuel Type: " + fuel);

        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        System.out.println("======Validating vehicle number=======");
        if (number == null || !Pattern.matches("^[A-Z]{2}-[0-9]{2}-[A-Z]{2}-[0-9]{4}$", number.toUpperCase())) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid vehicle number format Provide valid format Example: KA-01-AB-1234</p>");
            out.println("<a href='/static/vehicle.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating insurance date=======");
        if (insurance != null && !insurance.isEmpty()) {
            try {
                LocalDate insuranceDate = LocalDate.parse(insurance, DateTimeFormatter.ISO_LOCAL_DATE);
                if (insuranceDate.isBefore(LocalDate.now())) {
                    out.println("<html><body>");
                    out.println("<h1 style='color:red;'>Validation Error</h1>");
                    out.println("<p>Insurance date must be in the future</p>");
                    out.println("<a href='/static/vehicle.html'>Go Back</a>");
                    out.println("</body></html>");
                    return;
                }
            } catch (DateTimeParseException e) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Invalid insurance date format Use YYYY-MM-DD</p>");
                out.println("<a href='/static/vehicle.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }
        }

        System.out.println("======Validating fuel type=======");
        if (fuel == null || fuel.isEmpty()) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Fuel type is required</p>");
            out.println("<a href='/static/vehicle.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        String[] validFuelTypes = {"PETROL", "DIESEL", "CNG", "ELECTRIC", "HYBRID", "LPG"};
        boolean isValidFuel = false;
        for (String validType : validFuelTypes) {
            if (fuel.equalsIgnoreCase(validType)) {
                isValidFuel = true;
                break;
            }
        }
        if (!isValidFuel) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid fuel type Valid types: Petrol, Diesel, CNG, Electric, Hybrid, LPG</p>");
            out.println("<a href='/static/vehicle.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h1>Vehicle Registration Completed Successfully</h1>");
        out.println("</body></html>");
    }
}
