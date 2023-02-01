
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="CSS/css2.css">
    </head>
    <body>
        <div class="container">
            <table>
                <tr>
                    <th>Item number</th>
                    <th>Item</th>
                    <th>Price</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>rice</td>
                    <td>3.25 JD</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>sugar</td>
                    <td>3.50 JD</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>dried beans</td>
                    <td>1.25 JD</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>canned beans</td>
                    <td>1.50 JD</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>canned corn</td>
                    <td>1.75 JD</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>dried fruit</td>
                    <td>4.00 JD</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>canned fish</td>
                    <td>0.50 JD</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>Yogurt</td>
                    <td>1.00 JD</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td>Peanut Butter</td>
                    <td>2.00 JD</td>
                </tr>
                <tr>
                    <td>10</td>
                    <td>tomato sauce</td>
                    <td>1.00 JD</td>
                </tr>
            </table>
        </div>
        <div>
            <form action="MainServlet" method="post"/>
                <div class="input-wrapper">
                    <input  class="input1" class="input" type="text" name="itemNumber" placeholder="Item number"/>
                </div>
                <div class="input-wrapper">
                    <input class="input2" class="input" type="text" name="itemQuantity" placeholder="Item quantity"/>
                </div>
                <div>
                    <button class="button1" type="submit" name="sharedButtonName" value="Add">Add</button>
                </div>
                <div>
                    <button class="button2" type="submit" name="sharedButtonName" value="next">next</button>
                </div>
        </div>
    </body>
</html>
