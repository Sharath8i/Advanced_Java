<%@ page import="java.sql.*, java.util.*" %>
<html>
<head><title>View Coffee Records</title></head>
<body>
<%
    Connection dbConnection = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        String url = "jdbc:mysql://localhost/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "");

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, info);

        out.println("<h2>Connected to MySQL database 'test'</h2>");
        String query = "SELECT * FROM coffee";
        st = dbConnection.createStatement();
        rs = st.executeQuery(query);

        out.println("<h3>Current Coffee Records:</h3>");
        out.println("<table border='1'><tr><th>ID</th><th>Coffee Name</th><th>Price</th><th>Action</th></tr>");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("coffee_name");
            int price = rs.getInt("priced");

            out.println("<tr>");
            out.println("<td>" + id + "</td>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + price + "</td>");
            out.println("<td><a href='updateCoffee.jsp?id=" + id + "'>Update</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        rs.close();
        st.close();
        dbConnection.close();
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    }
%>
</body>
</html>
