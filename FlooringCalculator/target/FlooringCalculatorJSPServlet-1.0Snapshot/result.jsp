<%-- 
    Document   : result
    Created on : May 19, 2019, 9:49:21 AM
    Author     : keb03_000
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results</h1>
       <p>
            <c:out value="Your flooring cost: $${flooringCost}" />
        </p>
        <p>
            <c:out value="Your labor cost: $${laborCost} " />
        </p>
        <p>
            <c:out value="Your time required (in hours): ${timeRequired} " />
        </p>
        <p>
            <c:out value="Your total cost: $${totalCost} " />
        </p>          
        <p>
            <a href="index.jsp">Floor Another One!</a>
        </p>
        
    </body>
</html>
