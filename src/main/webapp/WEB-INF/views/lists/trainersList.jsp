<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Trainers List</title>
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
                    <h2>Trainers List</h2>
                    <table class="table table-bordered table-striped">
                        <thead class="thead-light">
                        <tr>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <%--@elvariable id="trainersList" type="java.util.List"--%>
                        <c:forEach items="${trainersList}" var="trainer">
                            <tr>
                                <td>${trainer.firstName}</td>
                                <td>${trainer.lastName}</td>
                                <td>
                                    <a href="updateTrainer?trainer_id=${trainer.id}">Edit</a>
                                </td>
                                <td>
                                    <a href="deleteTrainer?trainer_id=${trainer.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="<c:url value="/managers/createTrainer"/>">Create a new trainer..</a>
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