<%@ page import="java.sql.*, java.util.Properties" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee Manager</title>
</head>
<body>
    <h2>Update Coffee Record</h2>

    <form method="post" action="coffeeManager.jsp">
        <label for="id">Coffee ID:</label>
        <input type="number" name="id" required><br><br>

        <label for="coffee_name">Coffee Name:</label>
        <input type="text" name="coffee_name" required><br><br>

        <label for="priced">Price:</label>
        <input type="number" name="priced" required><br><br>

        <input type="submit" value="Update Coffee">
    </form>

    <hr>

<%
    Connection dbConnection = null;
    Statement st = null;
    ResultSet rs = null;

    String idStr = request.getParameter("id");
    String coffeeName = request.getParameter("coffee_name");
    String pricedStr = request.getParameter("priced");

    try {
        String url = "jdbc:mysql://localhost/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "");

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, info);

        // If form was submitted
        if (idStr != null && coffeeName != null && pricedStr != null) {
            int id = Integer.parseInt(idStr);
            int priced = Integer.parseInt(pricedStr);

            String updateQuery = "UPDATE coffee SET coffee_name = ?, priced = ? WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(updateQuery);
            ps.setString(1, coffeeName);
            ps.setInt(2, priced);
            ps.setInt(3, id);

            int updated = ps.executeUpdate();

            if (updated > 0) {
                out.println("<p style='color:green;'>Record updated successfully!</p>");
            } else {
                out.println("<p style='color:red;'>No record found with ID = " + id + ".</p>");
            }

            ps.close();
        }

        // Display all coffee records
        st = dbConnection.createStatement();
        rs = st.executeQuery("SELECT * FROM coffee");

        out.println("<h3>Current Coffee Records:</h3>");
        out.println("<table border='1'><tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                        rs.getString("coffee_name") + "</td><td>" +
                        rs.getInt("priced") + "</td></tr>");
        }
        out.println("</table>");

        rs.close();
        st.close();
        dbConnection.close();

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        e.printStackTrace(new java.io.PrintWriter(out));
    }
%>
</body>
</html>
