<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">

</head>
<body>
    <div id="login">
        <h1>*Donation food type</h1>
        <form action="MainServlet" method="post"/>
                <h3>Packages<input style="position: absolute;left: 120px;" type="radio" name="radioName" value="package"/><br></h3>
                <h3>Choose items<input style="position: absolute;left: 120px;"type="radio" name="radioName" value="single"/><br></h3>
        <br><br><br><br>
        <button type="submit" name="sharedButtonName" value=" Next ">Next</button>
    </div>
</body>
</html>
