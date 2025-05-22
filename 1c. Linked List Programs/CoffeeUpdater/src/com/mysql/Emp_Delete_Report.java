package com.mysql;

import java.sql.*;

public class Emp_Delete_Report {
    public static void main(String[] args) {
        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            System.out.println("✅ Connected to employee database");

            // Delete where name starts with 'S'
            String deleteQuery = "DELETE FROM Emp WHERE Emp_N0 LIKE 'd%'";
            PreparedStatement delStmt = dbConnection.prepareStatement(deleteQuery);
            int rows = delStmt.executeUpdate();
            System.out.println("✅ Deleted " + rows + " employee(s) with name starting with 'S'");

            // Generate remaining salary report
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Emp");

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

            delStmt.close();
            rs.close();
            dbConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
