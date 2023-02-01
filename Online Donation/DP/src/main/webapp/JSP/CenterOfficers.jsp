<%@ page import="model.Donor" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/1/2022
  Time: 6:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">
    <link rel="stylesheet" type="text/css" href="CSS/css2.css">
</head>
<body class="container">
<br><br>
    <h2 style="color: red; text-align: center">This page is dedicated to the support center</h2>;
    <jsp:useBean id="donor" class="model.Donor" scope="session"/>
    <table>
    <% for(int i=0;i< Donor.getSize();i++){%>
        <tr >
            <td ><%=Donor.getDonor(i).getDenotType()%></td >
            <td ><%=Donor.getDonor(i).getDonateDate()%></td >
            <td ><%=Donor.getDonor(i).getTotalSum()%></td >
            <td ><%=Donor.getDonor(i).getDonateTo()%></td >
            <td ><%=Donor.getDonor(i).getLocation()%></td >
            <td ><%=Donor.getDonor(i).getRepeatingDonate()%></td >
            <td ><%=Donor.getDonor(i).getSameDonees()%></td >
        </tr>
    <%}%>
    </table >
    <form action="MainServlet" method="post"/>
    <div class="container">
        <button type="submit" name="sharedButtonName" value="Receipt">Donation delivery</button>
    </div>
</body>
</html>
