
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Pizza</title>
    </head>
    <body>
        <h2>Delivery unavailable</h2>
        <p>The address is outside of our delivery area. You may still place the order, but you will need to pick it up yourself.</p>

        <a href="${flowExecutionUrl}&_eventId=accept">
            Continue, I will pick up the order
        </a>
        <a href="${flowExecutionUrl}&_eventId=cancel">
            Never mind
        </a>
    </body>
</html>
