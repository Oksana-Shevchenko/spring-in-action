<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="message/html; charset=UTF-8">
        <title>View user profile</title>
        <link href="<c:url value="/statics/css/messenger.css"/>" rel="stylesheet">
    </head>
    <body>
        <div id="view_profile">
            <table>
                <tr>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <td>${user.fullName}</td>
                </tr>
                <tr>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td>${user.password}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
