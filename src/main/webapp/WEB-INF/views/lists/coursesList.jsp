<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Courses List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Courses List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp" />
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>Vendor</th>
                    <th>Course code</th>
                    <th>Course name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%--@elvariable id="coursesList" type="java.util.List"--%>
                <c:forEach items="${coursesList}" var="course" >
                    <tr>
                        <td>${course.vendorName}</td>
                        <td>${course.courseCode}</td>
                        <td>${course.courseName}</td>
                        <td>
                            <a href="updateCourse?course_id=${course.id}">Edit</a>
                        </td>
                        <td>
                            <a href="deleteCourse?course_id=${course.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/managers/createCourse"/>">Create a new course..</a>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>