<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">

</head>
<body>
<div id="login">
    <h1>*Food package #no</h1>
    <form action="MainServlet" method="post"/>
    <a href="JSP/Package1Contents.jsp"><h3>Package #1 : 10JD<input style="position: absolute;left: 120px;" type="radio" name="packageNumberRadioName" value="1"/><br></h3></a>
    <a href="JSP/Package2Contents.jsp"><h3>Package #2 : 20JD<input style="position: absolute;left: 120px;"type="radio" name="packageNumberRadioName" value="2"/><br></h3></a>
    <a href="JSP/Package3Contents.jsp"><h3>Package #3 : 30JD<input style="position: absolute;left: 120px;" type="radio" name="packageNumberRadioName" value="3"/><br></h3></a>
    <br><br>
    <button type="submit" name="sharedButtonName" value="  Next  ">Next</button>
</div>
</body>
</html>