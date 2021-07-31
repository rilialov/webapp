<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Trainers List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Trainers List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp" />
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Edit</th>
                </tr>
                <%--@elvariable id="trainersList" type="java.util.List"--%>
                <c:forEach items="${trainersList}" var="trainer" >
                    <tr>
                        <td>${trainer.firstName}</td>
                        <td>${trainer.lastName}</td>
                        <td>
                            <a href="updateTrainer?trainer_id=${trainer.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/createTrainer"/>">Create a new trainer..</a>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>