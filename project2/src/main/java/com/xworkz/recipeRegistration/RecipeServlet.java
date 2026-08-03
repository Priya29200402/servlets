package com.xworkz.recipeRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/recipe")
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
        PrintWriter out = resp.getWriter();

        System.out.println("======Validating cooking time=======");
        try {
            int time = Integer.parseInt(cookingTime);

            if (time <= 0) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Cooking Time must be greater than 0</p>");
                out.println("<a href='/static/recipe.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Cooking Time</p>");
            out.println("<a href='/static/recipe.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating difficulty level=======");
        String[] levels = {"Easy", "Medium", "Hard"};
        boolean validLevel = false;

        for (String level : levels) {
            if (level.equalsIgnoreCase(difficulty)) {
                validLevel = true;
                break;
            }
        }

        if (!validLevel) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Difficulty must be Easy, Medium or Hard</p>");
            out.println("<a href='/static/recipe.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        System.out.println("======Validating calories=======");
        try {
            int cal = Integer.parseInt(calories);

            if (cal < 50 || cal > 2000) {
                out.println("<html><body>");
                out.println("<h1 style='color:red;'>Validation Error</h1>");
                out.println("<p>Calories must be between 50 and 2000</p>");
                out.println("<a href='/static/recipe.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1 style='color:red;'>Validation Error</h1>");
            out.println("<p>Invalid Calories</p>");
            out.println("<a href='/static/recipe.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h1>Recipe Added Successfully</h1>");
        out.println("</body></html>");
    }
}