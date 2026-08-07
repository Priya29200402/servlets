package com.xworkz.recipeRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/recipe",loadOnStartup = 1)
public class RecipeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String recipeName = req.getParameter("recipeName");
        String cuisineType = req.getParameter("cuisineType");
        String cookingTime = req.getParameter("cookingTime");
        String difficulty = req.getParameter("difficulty");
        String ingredients = req.getParameter("ingredients");
        String calories = req.getParameter("calories");

        System.out.println("Recipe Name: " + recipeName);
        System.out.println("Cuisine Type: " + cuisineType);
        System.out.println("Cooking Time: " + cookingTime);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Ingredients Count: " + ingredients);
        System.out.println("Calories: " + calories);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        boolean valid = true;

        // Cooking time validation
        try {
            int time = Integer.parseInt(cookingTime);
            if (time <= 0) {
                valid = false;
                writer.println("<h3 style='color:red'>Cooking Time must be greater than 0</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Cooking Time</h3>");
        }

        // Difficulty validation
        String[] levels = {"Easy", "Medium", "Hard"};
        boolean validLevel = false;
        for (String level : levels) {
            if (level.equalsIgnoreCase(difficulty)) {
                validLevel = true;
                break;
            }
        }
        if (!validLevel) {
            valid = false;
            writer.println("<h3 style='color:red'>Difficulty must be Easy, Medium or Hard</h3>");
        }

        // Calories validation
        try {
            int cal = Integer.parseInt(calories);
            if (cal < 50 || cal > 2000) {
                valid = false;
                writer.println("<h3 style='color:red'>Calories must be between 50 and 2000</h3>");
            }
        } catch (NumberFormatException e) {
            valid = false;
            writer.println("<h3 style='color:red'>Invalid Calories</h3>");
        }

        if (valid) {
            writer.println("<html>");
            writer.println("<body style='font-family:Arial;text-align:center;background:#f4f4f4;'>");
            writer.println("<h1 style='color:green'>Recipe Added Successfully</h1>");
            writer.println("<h3>Recipe Name : " + recipeName + "</h3>");
            writer.println("<h3>Cuisine Type : " + cuisineType + "</h3>");
            writer.println("<h3>Cooking Time : " + cookingTime + " minutes</h3>");
            writer.println("<h3>Difficulty : " + difficulty + "</h3>");
            writer.println("<h3>Ingredients Count : " + ingredients + "</h3>");
            writer.println("<h3>Calories : " + calories + "</h3>");
            writer.println("<br>");
            writer.println("<a href='recipe.html'>");
            writer.println("<button>Add Another Recipe</button>");
            writer.println("</a>");
            writer.println("<br><br>");
            writer.println("<a href='index.html'>");
            writer.println("<button>Go to Home</button>");
            writer.println("</a>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            writer.println("<br>");
            writer.println("<a href='recipe.html'>");
            writer.println("<button>Go Back</button>");
            writer.println("</a>");
        }

        writer.close();
    }
}