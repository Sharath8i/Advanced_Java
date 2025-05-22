package com.primecheck;

import java.io.*;
import jakarta.servlet.*; // updated
import jakarta.servlet.annotation.WebServlet; // updated
import jakarta.servlet.http.*; // updated

@WebServlet("/primecheck")
public class PrimeNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            out.println("<html><body>");
            out.println("<h2>Prime Number Checker</h2>");
            out.println("<p>Entered Number: " + number + "</p>");
            if (isPrime) {
                out.println("<p style='color:green'>" + number + " is a Prime Number.</p>");
            } else {
                out.println("<p style='color:red'>" + number + " is NOT a Prime Number.</p>");
            }
            out.println("<a href='index.html'>Check Another Number</a>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<p style='color:red'>Please enter a valid number.</p>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
