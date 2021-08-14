<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Users List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Users List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp" />
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>Login</th>
                    <th>Form ID</th>
                    <th>Manager</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%--@elvariable id="usersList" type="java.util.List"--%>
                <c:forEach items="${usersList}" var="user" >
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
<%--                            <a href="updateUsers?user_id=${user.id}">Edit</a>--%>
                        </td>
                        <td>
<%--                            <a href="deleteUsers?user_id=${user.id}">Delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
<%--            <a href="<c:url value="/managers/createUsers"/>">Create a new user..</a>--%>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>