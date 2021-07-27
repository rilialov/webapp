<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css" >
    <title>Trainers List</title>
</head>
<body>
<div class="all">
    <header>
        <a href="/"><img src="/view/styles/logo.png" alt="logo"></a>
    </header>
    <main>
        <h1>Trainers List</h1>
        <div class="left_side">
            <ul>
                <li><a href="/studentsList">Students List</a></li>
                <li><a href="/trainersList">Trainers List</a></li>
                <li><a href="/">Courses List</a></li>
            </ul>
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
        <div>Copyright © 2021</div>
    </footer>
</div>
</body>
</html>