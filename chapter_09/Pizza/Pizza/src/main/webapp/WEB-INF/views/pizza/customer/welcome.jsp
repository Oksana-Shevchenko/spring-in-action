
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored ="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Pizza</title>
    </head>
    <body>
        <h2>Welcome to Pizza!!!</h2>
        ${flowExecutionKey}
        ${flowExecutionUrl}

        <form action="${flowExecutionUrl}&_eventId=phoneEntered" method="post">
            <input type="hidden" name="_flowExecutionKey" value=""/>
            <input type="text" name="phoneNumber"/> <br/>
            <input type="submit" name="lookupCustomer" value="Lookup Customer"/>
        </form>
    </body>
</html>
