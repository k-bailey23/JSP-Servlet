<%-- 
    Document   : index
    Created on : May 19, 2019, 9:48:57 AM
    Author     : keb03_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>Flooring Calculator</h1>
        <p>
            Please enter your flooring project specs below:
        </p>
        <p>
        <form method="POST" action="FlooringCalculatorServlet">
                <label>Width (in feet): </label>
                <input type="text" name="width" />
                <label>Length (in feet): </label>
                <input type="text" name="length" />
                <label>Cost per square foot (in USD): </label>
                <input type="text" name="costPerSqFt" />
                <input type ="submit" value="Calculate!!!" />
        </form>
        </p>
    </body>
</html>
