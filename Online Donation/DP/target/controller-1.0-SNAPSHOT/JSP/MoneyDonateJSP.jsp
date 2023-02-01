<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">

</head>
<body>
<div id="login">
    <h1>*Money donate page</h1>

        <form action="MainServlet" method="post"/>
        <div>
            <h3>Enter the donation amount</h3><input type="text" name="amount"/>
        </div>
        <br><br><br>
        <div>
            <button type="submit" name="sharedButtonName" value="save and continue">Next</button>
        </div>
</div>
</body>
</html>