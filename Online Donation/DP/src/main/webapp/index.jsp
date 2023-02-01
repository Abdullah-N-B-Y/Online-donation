<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">

</head>
<body>
    <div id="login">
        <h1>*Donation online app</h1>
        <form action="MainServlet1" method="post">
            <h3>Food<input style="position: absolute;left: 120px;" type="radio" name="radioName" value="food"/><br></h3>
            <h3>Household<input style="position: absolute;left: 120px;"type="radio" name="radioName" value="household"/><br></h3>
            <h3>Money<input style="position: absolute;left: 120px;" type="radio" name="radioName" value="money"/><br></h3>
            <br><br>
            <button type="submit" name="sharedButtonName" value="Next">Next</button>
            <button type="submit" name="sharedButtonName" value="Open donation center">Open donation center</button>
        </form>
    </div>
</body>
</html>