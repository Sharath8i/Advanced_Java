<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>
    <h2>Delete Employee by ID</h2>
    <form method="post">
        Enter Employee ID to Delete: <input type="text" name="empid" required />
        <input type="submit" value="Delete" />
    </form>
    <hr>

<%
    String empid = request.getParameter("empid");

    if (empid != null && !empid.trim().equals("")) {
        try {
            int id = Integer.parseInt(empid);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Emp WHERE Emp_NO = ?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<p style='color:green;'>Employee with ID " + id + " deleted successfully.</p>");
            } else {
                out.println("<p style='color:red;'>No employee found with ID " + id + ".</p>");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
%>

</body>
</html>