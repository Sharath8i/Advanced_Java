package com.factorial;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));

            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }
            if (number > 20) {
                throw new IllegalArgumentException("Number too large, maximum allowed is 20");
            }

            long factorial = 1;
            StringBuilder calculation = new StringBuilder("Calculation steps:<br>");

            if (number == 0 || number == 1) {
                factorial = 1;
                calculation.append(number).append("! = 1");
            } else {
                calculation.append(number).append("! = ");
                for (int i = number; i >= 1; i--) {
                    factorial *= i;
                    calculation.append(i);
                    if (i != 1) {
                        calculation.append(" × ");
                    }
                }
                calculation.append(" = ").append(factorial);
            }

            // Generate HTML response
            out.println("<html><head><title>Factorial Result</title>");
            out.println("<style>");
            out.println(".container { margin: 20px; padding: 20px; width: 500px; border: 1px solid #ccc; border-radius: 5px; }");
            out.println(".result { margin: 10px 0; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<div class='container'>");
            out.println("<h2>Factorial Result</h2>");
            out.println("<div class='result'>");
            out.println("<p>Number: " + number + "</p>");
            out.println("<p>Factorial: " + factorial + "</p>");
            out.println("<p>" + calculation + "</p>");
            out.println("</div>");
            out.println("<a href='index.html'>Calculate Another Factorial</a>");
            out.println("</div></body></html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    private void displayError(PrintWriter out, String message) {
        out.println("<html><head><title>Error</title></head><body>");
        out.println("<div style='margin: 20px; color: red;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</div></body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
