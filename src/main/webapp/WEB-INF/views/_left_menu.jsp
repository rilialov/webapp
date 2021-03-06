<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar bg-light">
<ul class="nav flex-column">
    <li><a href="<c:url value="/managers/studentsList"/>">Students List</a></li>
    <li><a href="<c:url value="/managers/vendorsList"/>">Vendors List</a></li>
    <li><a href="<c:url value="/managers/coursesList"/>">Courses List</a></li>
    <li><a href="<c:url value="/managers/trainersList"/>">Trainers List</a></li>
    <li><a href="<c:url value="/managers/formsList"/>">Forms List</a></li>
    <li><a href="<c:url value="/managers/usersList"/>">Users List</a></li>
</ul>
</nav>