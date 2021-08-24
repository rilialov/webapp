<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Users List</title>
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
                    <h2>Users List</h2>
                    <table class="table table-bordered table-striped">
                        <thead class="thead-light">
                        <tr>
                            <th>Login</th>
                            <th>Form ID</th>
                            <th>Manager</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <%--@elvariable id="usersList" type="java.util.List"--%>
                        <c:forEach items="${usersList}" var="user">
                            <tr>
                                <td>${user.login}</td>
                                <td>${user.form_id}</td>
                                <td>
                                    <c:if test="${user.manager == true}">
                                        Yes
                                    </c:if>
                                    <c:if test="${user.manager == false}">
                                        No
                                    </c:if>
                                </td>
                                <td>
                                    <a href="updateUser?user_id=${user.id}"><i class="bi bi-file-earmark-text"></i></a>
                                </td>
                                <td>
                                    <a href="deleteUser?user_id=${user.id}"><i class="bi bi-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a class="btn btn-primary" href="<c:url value="/managers/createUser"/>" role="button">Create <i
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