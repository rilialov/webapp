<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css">
    <title>Form</title>
</head>
<body>
<div class="all">
    <header>
        <a href="/"><img src="/view/styles/logo.png" alt="logo"></a>
    </header>
    <div class="main">
        <h1>Form</h1>
        <form action="update" method="post">
            <ul>
                <li>
                    <label for="course">Course:</label>
                    <textarea id="course" readonly>${course}</textarea>
                </li>
                <li>
                    <label for="trainer">Trainer:</label>
                    <input class="txtinput" type="text" id="trainer" value="${trainer}" readonly>
                </li>
                <li>
                    <label for="date">Date:</label>
                    <input class="txtinput" type="text" id="date" value="${date}" readonly>
                </li>
                <li>
                    <label for="firstname">First Name:</label>
                    <input class="txtinput" type="text" id="firstname" name="firstname" value="${firstname}">
                </li>
                <li>
                    <label for="lastname">Last Name:</label>
                    <input class="txtinput" type="text" id="lastname" name="lastname" value="${lastname}">
                </li>
                <li>
                    <label for="phone">Phone:</label>
                    <input class="txtinput" type="text" id="phone" name="phone" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                </li>
                <li>
                    <label for="email">E-mail:</label>
                    <input class="txtinput" type="text" id="email" name="email">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
            <input type="hidden" value="${login}" name="login" />
        </form>
    </div>
    <footer>
        <div>Copyright © 2021</div>
    </footer>
</div>
</body>
</html>