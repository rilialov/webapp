<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Manager Page</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <jsp:include page="_left_menu.jsp"/>
                </div>
                <div class="col-10">
                    <h2>Manager Page</h2>
                    <p>This page for managers..</p>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="_footer.jsp"/>
    </footer>
</div>
</body>