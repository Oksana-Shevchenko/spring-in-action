<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="message/html; charset=UTF-8">
		<title>Messenger</title>
		<link href="<c:url value="/statics/css/messenger.css"/>" rel="stylesheet">
	</head>
	<body>
		<h1>Messenger home page</h1>
		<h2>Look at what these people are spitting right now...</h2>
		<ol class="message-list">
			<c:forEach var="message" items="${messages}">
				<s:url value="/user/messages" var="user_url">
					<s:param name="user" value="${message.user.username}"/>
				</s:url>
				<li>
					<span class="messageListText">
						<a href="${user_url}"><c:out value="${message.user.username}"/></a>
						-
						<c:out value="${message.text}"/> <br/>
						<small><fmt:formatDate value="${message.createdAt}" pattern="hh:mma MMM d, yyyy"/></small>
					</span>
				</li>
			</c:forEach>
		</ol>
		<a href="/user/new">Create User</a>
		<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
			<sec:authentication property="principal" var="user"/>
			NAME= ${user.username}


		</sec:authorize>
	</body>
</html>
