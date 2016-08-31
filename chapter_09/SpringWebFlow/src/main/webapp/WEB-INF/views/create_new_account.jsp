<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored ="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>SpringWebFlow</title>
    </head>
    <body>

        <form action="${flowExecutionUrl}&_eventId=accountInformationEntered" method="post">

            <input type="hidden" name="_flowExecutionKey" value=""/>

            <br/>
            <br/>
            <table>
                <tr>
                    <td>New Login Name:</td>
                    <td><input type="text" name="loginName"/></td>
                </tr>
                <tr>
                    <td>Enter Password: </td>
                    <td><input type="text" name="password"/></td>
                </tr>
            </table>

            <br/>
            <input type="submit" value="Submit" />

        </form>
    </body>
</html>
