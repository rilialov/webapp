<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Forms List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Forms List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp" />
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>Course</th>
                    <th>Trainer</th>
                    <th>Student</th>
                    <th>Date</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%--@elvariable id="formsList" type="java.util.List"--%>
                <c:forEach items="${formsList}" var="form" >
                    <tr>
                        <td>${form.course_id}</td>
                        <td>${form.trainer_id}</td>
                        <td>${form.student_id}</td>
                        <td><tags:localDate date="${form.date}"/></td>
                        <td>
                            <a href="updateForm?form_id=${form.id}">Edit</a>
                        </td>
                        <td>
                            <a href="deleteForm?form_id=${form.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/managers/createForm"/>">Create a new form..</a>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>