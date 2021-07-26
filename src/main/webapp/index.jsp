<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css" >
    <title>Main</title>
</head>
<body>
<div class="all">
    <header>
        <a href="/"><img src="/view/styles/logo.png" alt="logo"></a>
    </header>
    <div class="main">
        <form action="form" method="post">
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
    </div>
    <footer>
        <div>Copyright © 2021</div>
    </footer>
</div>
</body>
</html>