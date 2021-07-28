<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css" >
    <title>Courses List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp"></jsp:include>
    </header>
    <main>
        <h1>Courses List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp"></jsp:include>
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>Course code</th>
                    <th>Course name</th>
                </tr>
                <c:forEach items="${coursesList}" var="course" >
                    <tr>
                        <td>${course.courseCode}</td>
                        <td>${course.courseName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>