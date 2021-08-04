<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Create Trainer</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Create Trainer</h1>
        <form action="createTrainer" method="post">
            <ul>
                <li>
                    <label for="firstname">First Name:</label>
                    <input class="txt_input" type="text" id="firstname" name="firstname" maxlength="20">
                </li>
                <li>
                    <label for="lastname">Last Name:</label>
                    <input class="txt_input" type="text" id="lastname" name="lastname" maxlength="20">
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