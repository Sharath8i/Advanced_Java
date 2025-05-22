<%@ page import="java.sql.*, java.util.Properties" %>
<html>
<head>
    <title>Dynamic Employee Deletion</title>
</head>
<body>
    <h2>Delete Employees by Name Starting Letter</h2>

    <!-- Input Form -->
    <form method="post" action="dynamicDeleteEmployee.jsp">
        <label>Enter Starting Letter of Emp Name: </label>
        <input type="text" name="startLetter" maxlength="1" required>
        <input type="submit" value="Delete">
    </form>
    <hr>

<%
    Connection conn = null;
    PreparedStatement deleteStmt = null;
    Statement selectStmt = null;
    ResultSet rs = null;

    String startLetter = request.getParameter("startLetter");

    try {
        String url = "jdbc:mysql://localhost/Employee";
        Properties info = new Properties();
        info.put("user", "root"); // Change if your MySQL username is different
        info.put("password", ""); // Add your MySQL password if required

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, info);

        if (conn != null) {
            out.println("<p style='color:green;'>Connected to the Employee database successfully.</p>");
        }

        // Delete records dynamically based on input
        if (startLetter != null && !startLetter.isEmpty()) {
            String deleteQuery = "DELETE FROM Emp WHERE Emp_Name LIKE ?";
            deleteStmt = conn.prepareStatement(deleteQuery);
            deleteStmt.setString(1, startLetter + "%");

            int rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted > 0) {
                out.println("<p style='color:blue;'>" + rowsDeleted + " record(s) deleted where name starts with '" + startLetter + "'</p>");
            } else {
                out.println("<p style='color:orange;'>No records found starting with '" + startLetter + "'</p>");
            }
        }

        // Display updated table content
        String selectQuery = "SELECT * FROM Emp";
        selectStmt = conn.createStatement();
        rs = selectStmt.executeQuery(selectQuery);

        out.println("<h3>Current Employee Records:</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>Emp_NO</th><th>Emp_Name</th><th>Basicsalary</th></tr>");

        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("Emp_NO") + "</td>");
            out.println("<td>" + rs.getString("Emp_Name") + "</td>");
            out.println("<td>" + rs.getInt("Basicsalary") + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        e.printStackTrace(new java.io.PrintWriter(out));
    } finally {
        try {
            if (deleteStmt != null) deleteStmt.close();
            if (rs != null) rs.close();
            if (selectStmt != null) selectStmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            out.println("<p style='color:red;'>Error closing resources: " + se.getMessage() + "</p>");
        }
    }
%>

</body>
</html>
