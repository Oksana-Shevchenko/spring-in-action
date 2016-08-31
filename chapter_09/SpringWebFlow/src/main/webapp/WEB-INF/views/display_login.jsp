<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored ="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>SpringWebFlow</title>
    </head>
    <body>
        <form action="${flowExecutionUrl}&_eventId=loginCredentialsEntered" method="post">

            <input type="hidden" name="_flowExecutionKey" value=""/>
            <br/>
            <b>
                Create a new account and then login
            </b>
            <br/>
            <br/>

            <table>
                <tr>
                    <td>Login Name:</td>
                    <td><input type="text" name="loginName"/></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="password"/></td>
                </tr>
            </table>

            <br/>
            <input type="submit" value="Login" />

        </form>

        <a href="${flowExecutionUrl}&_eventId=createNewAccountRequested">Create New Account</a>
    </body>
</html>
