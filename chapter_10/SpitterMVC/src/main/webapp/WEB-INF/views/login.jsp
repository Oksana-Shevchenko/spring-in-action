<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="message/html; charset=UTF-8">
        <title>Sign in</title>
    </head>
    <body>
        <div>
            <sec:authorize access="!isAuthenticated()">

            <h2>Sign in to Messenger</h2>
            <p>If you have been using Messenger from your phone then that's amazing...
            we don't support IM yet</p>
            <s:url var="authUrl" value="/statics/j_spring_security_check"/>
            <form method="post" class="signin" action="${authUrl}">
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="username_or_email">Username or Email</label></th>
                            <td><input id="username_or_email" name="j_username" type="text" /></td>
                        </tr>

                        <tr>
                            <th><label for="password">Password</label></th>
                            <td><input id="password" name="j_password" type="password"/></td>
                            <small><a href="/account/resend_password">Forgot?</a></small>
                        </tr>
                        <tr>
                            <th></th>
                            <td><input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                                <label for="remember_me" class="inline">Remember me</label>
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td><input name="commit" type="submit" value="Sign in"/></td>
                        </tr>
                    </table>
                </fieldset>
            </form>
            <script type="text/javascript"> document.getElementById('username_or_email').focus();
            </script>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <s:url value="/statics/j_spring_security_logout" var="logout_url" />
                <a href="${logout_url}">Logout</a>

                <sec:authorize url="admin">
                    <s:url value="/admin" var="admin_url"/>
                    <a href="${admin_url}">Admin</a>
                </sec:authorize>
            </sec:authorize>
        </div>
    </body>

</html>
