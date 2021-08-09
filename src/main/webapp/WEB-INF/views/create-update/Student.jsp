<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="student" type="com.test.webapp.model.Student"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Student</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Edit Student</h1>
        <form action="${create}Student" method="post">
            <ul>
                <li>
                    <label for="firstname">First Name:</label>
                    <input class="txt_input" type="text" id="firstname" name="firstname" value="${student.firstName}" maxlength="20">
                </li>
                <li>
                    <label for="lastname">Last Name:</label>
                    <input class="txt_input" type="text" id="lastname" name="lastname" value="${student.lastName}" maxlength="20">
                </li>
                <li>
                    <label for="phone">Phone:</label>
                    <input class="txt_input" type="text" id="phone" name="phone" value="${student.phone}" maxlength="20" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                </li>
                <li>
                    <label for="email">E-mail:</label>
                    <input class="txt_input" type="text" id="email" name="email" value="${student.email}" maxlength="30">
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