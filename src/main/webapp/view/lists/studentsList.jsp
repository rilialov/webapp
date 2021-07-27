<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css" >
    <title>Students List</title>
</head>
<body>
<div class="all">
    <header>
        <a href="/"><img src="/view/styles/logo.png" alt="logo"></a>
    </header>
    <main>
        <h1>Students List</h1>
        <div class="left_side">
            <ul>
                <li><a href="/studentsList">Students List</a></li>
                <li><a href="/trainersList">Trainers List</a></li>
                <li><a href="/coursesList">Courses List</a></li>
            </ul>
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>First name (edited)</th>
                    <th>Last name (edited)</th>
                    <th>Phone (edited)</th>
                    <th>Email (edited)</th>
                </tr>
                <c:forEach items="${studentsList}" var="student" >
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.phone}</td>
                        <td>${student.email}</td>
                        <td>${student.firstName_ed}</td>
                        <td>${student.lastName_ed}</td>
                        <td>${student.phone_ed}</td>
                        <td>${student.email_ed}</td>
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