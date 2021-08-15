<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="user" type="com.test.webapp.sessions.UserAccount"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit User</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Edit User</h1>
        <form action="${create}User" method="post">
            <ul>
                <li>
                    <label for="login">Login:</label>
                    <input class="txt_input" type="text" id="login" name="login" maxlength="20" value="${user.login}">
                </li>
                <li>
                    <label for="password">Password:</label>
                    <input class="txt_input" type="text" id="password" name="password" maxlength="20">
                </li>
                <li>
                    <label for="form">Form:</label>
                    <input class="txt_input" type="text" id="form" name="form" maxlength="20" value="${user.form_id}">
                </li>
                <li>
                    <label for="manager">Manager:</label>
                    <input class="txt_input" type="text" id="manager" name="manager" maxlength="20" value="${user.manager}">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>