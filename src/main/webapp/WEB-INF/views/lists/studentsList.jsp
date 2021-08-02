<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Students List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Students List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp" />
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>First name (edited)</th>
                    <th>Last name (edited)</th>
                    <th>Phone (edited)</th>
                    <th>Email (edited)</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%--@elvariable id="studentsList" type="java.util.List"--%>
                <c:forEach items="${studentsList}" var="student" >
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.phone}</td>
                        <td>${student.email}</td>
                        <td>${student.firstName_ed}</td>
                        <td>${student.lastName_ed}</td>
                        <td>${student.phone_ed}</td>
                        <td>${student.email_ed}</td>
                        <td>
                            <a href="updateStudent?student_id=${student.id}">Edit</a>
                        </td>
                        <td>
                            <a href="deleteStudent?student_id=${student.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/createStudent"/>">Create a new student..</a>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>