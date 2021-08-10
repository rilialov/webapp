<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="form" type="com.test.webapp.model.Form"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Form</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Edit Form</h1>
        <form action="${create}Form" method="post">
            <ul>
                <li>
                    <label for="course">Course:</label>
                    <textarea id="course" name="course_id">${form.course_id}</textarea>
                </li>
                <li>
                    <label for="trainer">Trainer:</label>
                    <input class="txt_input" type="text" id="trainer" name="trainer_id" value="${form.trainer_id}">
                </li>
                <li>
                    <label for="student">Student:</label>
                    <input class="txt_input" type="text" id="student" name="student_id" value="${form.student_id}">
                </li>
                <li>
                    <label for="date">Date:</label>
                    <input class="txt_input" type="date" id="date" name="date" value="${form.date}">
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