<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="view/styles/main.css" >
    <title>Courses List</title>
</head>
<body>
<div class="all">
    <header>
        <a href="/"><img src="/view/styles/logo.png" alt="logo"></a>
    </header>
    <main>
        <h1>Courses List</h1>
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
                    <th>Course code</th>
                    <th>Course name</th>
                </tr>
                <c:forEach items="${coursesList}" var="course" >
                    <tr>
                        <td>${course.courseCode}</td>
                        <td>${course.courseName}</td>
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