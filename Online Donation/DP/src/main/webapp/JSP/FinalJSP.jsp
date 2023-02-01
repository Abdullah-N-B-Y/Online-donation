
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">
    <link rel="stylesheet" type="text/css" href="CSS/css2.css">
</head>
<body>
    <div id="login">
        <h2 style="color: forestgreen; text-align: center">Donated successfully</h2>
    </div>
    <div>
        <form action="MainServlet" method="post"/>
    </div>
        <div class="container">
            <button style="position: absolute;top:200px ;left: 100px;" type="submit" name="sharedButtonName" value="Open center">Open donation center</button>
        </div>
        <div class="container">
            <button style="position: absolute;top:200px ;left: -100px;" type="submit" name="sharedButtonName" value="Back to main">Home</button>
        </div>
</body>
</html>
