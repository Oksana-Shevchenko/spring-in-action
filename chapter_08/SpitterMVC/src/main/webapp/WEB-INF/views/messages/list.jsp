<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="message/html; charset=UTF-8">
        <title>Messenger</title>
        <link href="<c:url value="/statics/css/messenger.css"/>" rel="stylesheet">
    </head>
    <body>
        <div>
            <h2>Messages for ${user.username}</h2>
            <table cellspacing="15">
                <c:forEach var="message" items="${messageList}">
                    <tr><td>
                        <a href="<s:url value="/users/${message.user.username}"/>"><c:out value="${message.user.username}"/></a>
                        <c:out value="${message.text}"/>
                        <c:out value="${message.createdAt}"/>
                    </td></tr>

                </c:forEach>

            </table>
        </div>
    </body>
</html>