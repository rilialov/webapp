<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="trainer" type="com.test.webapp.model.Trainer"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Trainer</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Edit Trainer</h1>
        <form action="${create}Trainer" method="post">
            <ul>
                <li>
                    <label for="firstname">First Name:</label>
                    <input class="txt_input" type="text" id="firstname" name="firstname" maxlength="20" value="${trainer.firstName}">
                </li>
                <li>
                    <label for="lastname">Last Name:</label>
                    <input class="txt_input" type="text" id="lastname" name="lastname" maxlength="20" value="${trainer.lastName}">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>