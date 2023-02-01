
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City-village</title>
    <link rel="stylesheet" type="text/css" href="CSS/css1.css">
    <link rel="stylesheet" type="text/css" href="CSS/css2.css">
</head>
<body>
    <div>
        <form action="MainServlet" method="post"/>
        <div style="position: absolute;left: 140px;">
                <h2><%out.print("Choose the location of the person in need");%><br><h2/>
            <ul >
                <h5><li>A needy person from the city<input style="position: absolute;left: 400px;height: 20px;width: 20px"type="radio" name="locationName" value="City"/></li></h5>
                <h5><li>A needy person from the village (+1 JD)<input style="position: absolute;left: 400px;height: 20px;width: 20px" type="radio" name="locationName" value="Village"/></li></h5>
            </ul>
                <h2><%out.print("Choose the people you want to donate to");%><br><h2/>
            <ul>
                <h5><li>orphans<input style="position: absolute;left: 140px;height: 20px;width: 20px"type="radio" name="typeDoneesRadioName" value="orphans"/></li></h5>
                <h5><li>widows<input style="position: absolute;left: 140px;height: 20px;width: 20px"type="radio" name="typeDoneesRadioName" value="widows"/></li></h5>
                <h5><li>refugees<input style="position: absolute;left: 140px;height: 20px;width: 20px"type="radio" name="typeDoneesRadioName" value="people with disabilities"/></li></h5>
                <h5><li>disabilities<input style="position: absolute;left: 140px;height: 20px;width: 20px"type="radio" name="typeDoneesRadioName" value="disabilities"/></li></h5>
                <h5><li>students<input style="position: absolute;left: 140px;height: 20px;width: 20px"type="radio" name="typeDoneesRadioName" value="students"/></li></h5>
            </ul>
                    <h2><%out.print("Choose how you want to donate");%><br><h2/>
            <ul>
                <h5><li>One time donation<input style="position: absolute;left: 280px; height: 20px;width: 20px"type="radio" name="wayDoneesRadioName" value="One Time"/></li></h5>
                <h5><li>Donate monthly<input style="position: absolute;left: 280px; height: 20px;width: 20px"type="radio" name="wayDoneesRadioName" value="Monthly"/></li></h5>
                <h5><li>Donate every four months<input style="position: absolute;left: 280px;height: 20px;width: 20px"type="radio" name="wayDoneesRadioName" value="Every four Months"/></li></h5>
                <h5><li>Donate annually<input style="position: absolute;left: 280px;height: 20px;width: 20px"type="radio" name="wayDoneesRadioName" value="Annually"/></li></h5>
            </ul>
        </div>
            <button class="button1" type="submit" name="sharedButtonName" value="   Next   ">Next</button>
    </div>
</body>
</html>
