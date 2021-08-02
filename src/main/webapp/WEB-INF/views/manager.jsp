<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Manager Page</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="_header.jsp" />
    </header>
    <main>
        <h1>Manager Page</h1>
        <div class="left_side">
            <jsp:include page="_left_menu.jsp" />
        </div>
        <div class="center">
            <p>This page for managers..</p>
        </div>
    </main>
    <footer>
        <jsp:include page="_footer.jsp" />
    </footer>
</div>
</body>