<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css" >
    <title>Main</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="views/_header.jsp"></jsp:include>
    </header>
    <main>
        <form action="mainPage" method="post">
            <ul>
                <li>
                    <label for="name">Login:</label>
                    <input class="txtinput" type="text" id="name" name="name">
                </li>
                <li>
                    <label for="pass">Password:</label>
                    <input class="txtinput" type="text" id="pass" name="pass">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="views/_footer.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>