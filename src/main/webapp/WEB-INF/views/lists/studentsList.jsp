<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Students List</title>
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
                    <h2>Students List</h2>
                    <table class="table table-bordered table-striped">
                        <thead class="thead-light">
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
                        </thead>
                        <%--@elvariable id="studentsList" type="java.util.List"--%>
                        <c:forEach items="${studentsList}" var="student">
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
                                    <a href="updateStudent?student_id=${student.id}"><i
                                            class="bi bi-file-earmark-text"></i></a>
                                </td>
                                <td>
                                    <a href="deleteStudent?student_id=${student.id}"><i class="bi bi-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a class="btn btn-primary" href="<c:url value="/managers/createStudent"/>" role="button">Create <i
                            class="bi bi-file-earmark-plus"></i></a>
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