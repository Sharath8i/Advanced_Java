 /*Read all the existing records from the table coffee which is from the database test and delete 
an existing coffee product  from the table with its id*/



package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Delete {
    public static void main(String[] args) {
        try {
            Connection dbConnection = null;
            String url = "jdbc:mysql://localhost:3306/test";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");

            dbConnection = DriverManager.getConnection(url, info);
            System.out.println("✅ Connected to MySQL database");

            // Display all records
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM coffee");

            while (rs.next()) {
                System.out.printf("\nID: %d | Name: %s | Price: %d", 
                    rs.getInt("id"), rs.getString("coffee_name"), rs.getInt("price"));
            }

            // Delete a record with id = 264
            String deleteQuery = "DELETE FROM coffee WHERE id = ?";
            PreparedStatement pstmt = dbConnection.prepareStatement(deleteQuery);
            pstmt.setInt(1, 102);
            pstmt.executeUpdate();
            System.out.println("\n✅ Deleted coffee with ID = 102");

            pstmt.close();
            dbConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
