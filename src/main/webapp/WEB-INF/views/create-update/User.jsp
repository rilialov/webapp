<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="user" type="com.test.webapp.sessions.UserAccount"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit User</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp"/>
    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <jsp:include page="../_left_menu.jsp"/>
                </div>
                <div class="col-10">
                    <h2>Edit User</h2>
                    <div class="row">
                        <div class="col container">
                            <form action="${create}User" method="post">
                                <div class="form-group">
                                    <label for="login">Login:</label>
                                    <input class="form-control" type="text" id="login" name="login" maxlength="20"
                                           value="${user.login}">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input class="form-control" type="text" id="password" name="password"
                                           maxlength="20">
                                </div>
                                <div class="form-group">
                                    <label for="form">Form:</label>
                                    <input class="form-control" type="text" id="form" name="form" maxlength="20"
                                           value="${user.form_id}">
                                </div>
                                <div class="form-group">
                                    <label for="manager">Manager:</label>
                                    <input class="form-control" type="text" id="manager" name="manager" maxlength="20"
                                           value="${user.manager}">
                                </div>
                                <button type="submit" class="btn btn-primary">OK</button>
                            </form>
                        </div>
                        <div class="col"></div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp"/>
    </footer>
</div>
</body>
</html>