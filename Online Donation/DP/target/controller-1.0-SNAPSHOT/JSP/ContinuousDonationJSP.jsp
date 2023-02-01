
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">
</head>
<body>
    <div id="login">
        <h2 style="text-align: center">Who donate every time</h2>
        <form action="MainServlet" method="post"/>
                <ul>
                    <h4><li>Random every time<input style="position: absolute;left: 270px; top:75px; height: 20px;width: 20px"type="radio" name="radioName" value="random"/></li></h4>
                    <h4><li>Same category every time<input style="position: absolute;left: 270px; top:120px; height: 20px;width: 20px"type="radio" name="radioName" value="sameCategory"/></li></h4>
                    <h4><li>Same person<input style="position: absolute;left: 270px; top:170px; height: 20px;width: 20px"type="radio" name="radioName" value="samePerson"/></li></h4>
                </ul>
        <br><br>
        <button type="submit" name="sharedButtonName" value="Donate">Finish</button>
    </div>
</body>
</html>
