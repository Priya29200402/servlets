package com.xworkz.vehicleRegistration;

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

@WebServlet("/vehicle")
public class VehicleServlet extends HttpServlet {

    private static final Pattern VEHICLE_PATTERN =
            Pattern.compile("^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String ownerName = req.getParameter("name");
        String vehicleNumber = req.getParameter("number");
        String vehicleType = req.getParameter("type");
        String registrationDate = req.getParameter("date");
        String insuranceDate = req.getParameter("insurance");
        String fuelType = req.getParameter("fuel");

        System.out.println("Owner Name : " + ownerName);
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type : " + vehicleType);
        System.out.println("Registration Date : " + registrationDate);
        System.out.println("Insurance Date : " + insuranceDate);
        System.out.println("Fuel Type : " + fuelType);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        boolean valid = true;

        // Owner Name Validation
        if (ownerName == null || ownerName.trim().length() < 3) {
            valid = false;
            writer.println("<h3 style='color:red'>Owner Name is Invalid</h3>");
        }

        // Vehicle Number Validation
        if (vehicleNumber == null ||
                !VEHICLE_PATTERN.matcher(vehicleNumber.toUpperCase()).matches()) {

            valid = false;
            writer.println("<h3 style='color:red'>Vehicle Number must be like KA01AB1234</h3>");
        }

        // Vehicle Type Validation
        if (!(vehicleType.equalsIgnoreCase("Car") ||
                vehicleType.equalsIgnoreCase("Bike") ||
                vehicleType.equalsIgnoreCase("Bus") ||
                vehicleType.equalsIgnoreCase("Truck"))) {

            valid = false;
            writer.println("<h3 style='color:red'>Invalid Vehicle Type</h3>");
        }

        // Registration Date Validation
        try {

            LocalDate regDate = LocalDate.parse(registrationDate);

            if (regDate.isAfter(LocalDate.now())) {

                valid = false;
                writer.println("<h3 style='color:red'>Registration Date cannot be Future</h3>");

            }

        } catch (DateTimeParseException e) {

            valid = false;
            writer.println("<h3 style='color:red'>Invalid Registration Date</h3>");

        }

        // Insurance Date Validation
        try {

            LocalDate insurance = LocalDate.parse(insuranceDate);

            if (!insurance.isAfter(LocalDate.now())) {

                valid = false;
                writer.println("<h3 style='color:red'>Insurance Date must be Future Date</h3>");

            }

        } catch (DateTimeParseException e) {

            valid = false;
            writer.println("<h3 style='color:red'>Invalid Insurance Date</h3>");

        }

        // Fuel Type Validation
        if (!(fuelType.equalsIgnoreCase("Petrol") ||
                fuelType.equalsIgnoreCase("Diesel") ||
                fuelType.equalsIgnoreCase("Electric") ||
                fuelType.equalsIgnoreCase("CNG"))) {

            valid = false;
            writer.println("<h3 style='color:red'>Invalid Fuel Type</h3>");

        }

        if (valid) {

            writer.println("<html>");
            writer.println("<body style='font-family:Arial;text-align:center;background:#f4f4f4;'>");

            writer.println("<h1 style='color:green'>Vehicle Registered Successfully</h1>");

            writer.println("<h3>Owner Name : " + ownerName + "</h3>");
            writer.println("<h3>Vehicle Number : " + vehicleNumber.toUpperCase() + "</h3>");
            writer.println("<h3>Vehicle Type : " + vehicleType + "</h3>");
            writer.println("<h3>Registration Date : " + registrationDate + "</h3>");
            writer.println("<h3>Insurance Valid Till : " + insuranceDate + "</h3>");
            writer.println("<h3>Fuel Type : " + fuelType + "</h3>");

            writer.println("<br>");
            writer.println("<a href='vehicle.html'>");
            writer.println("<button>Register Another Vehicle</button>");
            writer.println("</a>");

            writer.println("</body>");
            writer.println("</html>");

        } else {

            writer.println("<br>");
            writer.println("<a href='vehicle.html'>");
            writer.println("<button>Go Back</button>");
            writer.println("</a>");

        }

        writer.close();
    }
}