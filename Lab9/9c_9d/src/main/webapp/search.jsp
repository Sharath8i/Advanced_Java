<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>
<h2>Search Employee by First Letter</h2>

<form method="post">
    <label>Enter first letter of name:</label>
    <input type="text" name="letter" maxlength="1" required>
    <input type="submit" value="Search">
</form>

<%
    String letter = request.getParameter("letter");

    if (letter != null && !letter.trim().isEmpty()) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            String sql = "SELECT * FROM Emp WHERE Emp_Name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, letter + "%");

            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
%>
            <h3>Search Results:</h3>
            <table border="1">
                <tr>
                    <th>Emp_NO</th>
                    <th>Emp_Name</th>
                    <th>Basic Salary</th>
                </tr>
<%
            while (rs.next()) {
                found = true;
%>
                <tr>
                    <td><%= rs.getInt("Emp_NO") %></td>
                    <td><%= rs.getString("Emp_Name") %></td>
                    <td><%= rs.getInt("Basicsalary") %></td>
                </tr>
<%
            }
            rs.close();
            pstmt.close();
            conn.close();

            if (!found) {
                out.println("<p>No employees found starting with letter: " + letter + "</p>");
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
%>

<br><a href="index.jsp">Go Back</a>
</body>
</html>