<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="views/styles/main.css" >
    <title>Trainers List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp"></jsp:include>
    </header>
    <main>
        <h1>Trainers List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp"></jsp:include>
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                </tr>
                <c:forEach items="${trainersList}" var="trainer" >
                    <tr>
                        <td>${trainer.firstName}</td>
                        <td>${trainer.lastName}</td>
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