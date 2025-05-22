package com.mysql;

import java.sql.*;
import java.util.Scanner;

public class Emp_Insert_Report {
    public static void main(String[] args) {
        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            System.out.println("✅ Connected to employee database");

            Scanner sc = new Scanner(System.in);
            PreparedStatement insertStmt = dbConnection.prepareStatement("INSERT INTO Emp VALUES (?, ?, ?)");

            for (int i = 0; i < 5; i++) {
                System.out.print("Enter Emp No: ");
                int eno = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter Emp Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Basic Salary: ");
                int salary = sc.nextInt();

                insertStmt.setInt(1, eno);
                insertStmt.setString(2, name);
                insertStmt.setInt(3, salary);
                insertStmt.executeUpdate();
            }

            // Salary Report
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Emp WHERE Emp_Name LIKE 'R%'");

            int total = 0;
            System.out.println("\n~~~~ Salary Report ~~~~");
            while (rs.next()) {
                int eno = rs.getInt("Emp_NO");
                String name = rs.getString("Emp_Name");
                int basic = rs.getInt("Basicsalary");

                total += basic;
                System.out.printf("Emp_No : %d\nEmp_Name: %s\nBasic   : %d\n------------------\n", eno, name, basic);
            }

            System.out.println("Grand Salary: " + total);

            sc.close();
            rs.close();
            insertStmt.close();
            dbConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
