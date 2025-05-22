package com.mysql;
import java.sql.*;
import java.util.Scanner;

public class DeleteEmployeeByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

            // 3. Delete employees whose name starts with 'S'
            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM Emp WHERE Emp_Name LIKE 'S%'");
            int deletedRows = deleteStmt.executeUpdate();
            System.out.println(deletedRows + " record(s) deleted where Emp_Name starts with 'S'.");

            // 4. Show report
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Emp");

            System.out.println("\nSalary Report");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            while (rs.next()) {
                int id = rs.getInt("Emp_NO");
                String name = rs.getString("Emp_Name");
                int salary = rs.getInt("Basicsalary");

                System.out.println("Emp_No    : " + id);
                System.out.println("Emp_Name  : " + name);
                System.out.println("Basic     : " + salary);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            rs.close();
            stmt.close();
            deleteStmt.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                scanner.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
