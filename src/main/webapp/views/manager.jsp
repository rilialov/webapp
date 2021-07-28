<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="views/styles/main.css" >
    <title>Manager Page</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="_header.jsp"></jsp:include>
    </header>
    <main>
        <h1>Manager Page</h1>
        <div class="left_side">
            <jsp:include page="_left_menu.jsp"></jsp:include>
        </div>
        <div class="center">
            <p>This page for managers..</p>
        </div>
    </main>
    <footer>
        <jsp:include page="_footer.jsp"></jsp:include>
    </footer>
</div>
</body>