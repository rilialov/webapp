<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="form" type="com.test.webapp.model.Form"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Form</title>
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
                    <h2>Edit Form</h2>
                    <div class="row">
                        <div class="col container">
                            <form action="${create}Form" method="post">
                                <div class="form-group">
                                    <label for="course">Course:</label>
                                    <textarea class="form-control" id="course" name="course_id">${form.course_id}</textarea>
                                </div>
                                <div class="form-group">
                                    <label for="trainer">Trainer:</label>
                                    <input class="form-control" type="text" id="trainer" name="trainer_id"
                                           value="${form.trainer_id}">
                                </div>
                                <div class="form-group">
                                    <label for="student">Student:</label>
                                    <input class="form-control" type="text" id="student" name="student_id"
                                           value="${form.student_id}">
                                </div>
                                <div class="form-group">
                                    <label for="date">Date:</label>
                                    <input class="form-control" type="date" id="date" name="date" value="${form.date}">
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