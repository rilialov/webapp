<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="views/styles/main.css">
    <title>Edit Trainer</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp"></jsp:include>
    </header>
    <main>
        <h1>Edit Trainer</h1>
        <form action="updateTrainer" method="post">
            <ul>
                <li>
                    <label for="firstname">First Name:</label>
                    <input class="txtinput" type="text" id="firstname" name="firstname" value="${trainer.firstName}">
                </li>
                <li>
                    <label for="lastname">Last Name:</label>
                    <input class="txtinput" type="text" id="lastname" name="lastname" value="${trainer.lastName}">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>