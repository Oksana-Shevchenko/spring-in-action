<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="message/html; charset=UTF-8">
        <title>Create user profile</title>
        <link href="<c:url value="/statics/css/messenger.css"/>" rel="stylesheet">
    </head>
    <body>
        <div>
            <h2>Create a free User account</h2>
            <sec:authorize access="isAnonymous()">
            <sf:form method="post" modelAttribute="user" action="/user/save" enctype="multipart/form-data">
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="user_full_name">Full name:</label></th>
                            <td><sf:input path="fullName" size="15" id="user_full_name"/>
                                <sf:errors path="fullName" cssclass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="user_screen_name">Username:</label></th>
                            <td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
                                <small id="username_msg">No spaces, please.</small>
                                <sf:errors path="username" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="user_password">Password:</label></th>
                            <td><sf:input path="password" size="15" showPassword="true" id="user_password"/>
                                <small>6 characters or more.</small>
                                <sf:errors path="password" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="user_email">Email:</label></th>
                            <td><sf:input path="email" size="15" showPassword="true" id="user_email"/>
                                <small>In case you forget something</small>
                                <sf:errors path="email" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="image">Profile image:</label></th>
                            <td><input name="image" type="file" id="image"/></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td><input type="submit" value="Submit"></td>
                        </tr>
                    </table>
                </fieldset>
             </sf:form>
            </sec:authorize>
        </div>
    </body>
</html>