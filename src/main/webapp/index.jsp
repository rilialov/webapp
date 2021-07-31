<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Main Page</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="views/_header.jsp" />
    </header>
    <main>
        <form action="mainPage" method="post">
            <ul>
                <li>
                    <label for="name">Login:</label>
                    <input class="txt_input" type="text" id="name" name="name">
                </li>
                <li>
                    <label for="pass">Password:</label>
                    <input class="txt_input" type="text" id="pass" name="pass">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="views/_footer.jsp" />
    </footer>
</div>
</body>
</html>