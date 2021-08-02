<%--@elvariable id="firstname" type="com.test.webapp.model.Student"--%>
<%--@elvariable id="lastname" type="com.test.webapp.model.Student"--%>
<%--@elvariable id="date" type="com.test.webapp.model.Form"--%>
<%--@elvariable id="course" type="com.test.webapp.model.Course"--%>
<%--@elvariable id="trainer" type="com.test.webapp.model.Trainer"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Form</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="_header.jsp" />
    </header>
    <main>
        <h1>Form</h1>
        <form action="update" method="post">
            <ul>
                <li>
                    <label for="course">Course:</label>
                    <textarea id="course" readonly>${course}</textarea>
                </li>
                <li>
                    <label for="trainer">Trainer:</label>
                    <input class="txt_input" type="text" id="trainer" value="${trainer}" readonly>
                </li>
                <li>
                    <label for="date">Date:</label>
                    <input class="txt_input" type="text" id="date" value="${date}" readonly>
                </li>
                <li>
                    <label for="firstname">First Name:</label>
                    <input class="txt_input" type="text" id="firstname" name="firstname" value="${firstname}">
                </li>
                <li>
                    <label for="lastname">Last Name:</label>
                    <input class="txt_input" type="text" id="lastname" name="lastname" value="${lastname}">
                </li>
                <li>
                    <label for="phone">Phone:</label>
                    <input class="txt_input" type="text" id="phone" name="phone" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                </li>
                <li>
                    <label for="email">E-mail:</label>
                    <input class="txt_input" type="text" id="email" name="email">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="_footer.jsp" />
    </footer>
</div>
</body>
</html>