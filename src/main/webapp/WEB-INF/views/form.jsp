<%--@elvariable id="firstname" type="com.test.webapp.model.Student"--%>
<%--@elvariable id="lastname" type="com.test.webapp.model.Student"--%>
<%--@elvariable id="date" type="com.test.webapp.model.Form"--%>
<%--@elvariable id="course" type="com.test.webapp.model.Course"--%>
<%--@elvariable id="trainer" type="com.test.entity.model.Trainer"--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Form</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="_header.jsp"/>
    </header>
    <main>
        <div class="container">
            <h2>Form</h2>
            <div class="row">
                <div class="col"></div>
                <div class="col container border border-dark">
                    <form action="formUpdate" method="post">
                        <div class="form-group">
                            <label for="course">Course:</label>
                            <textarea class="form-control" id="course" readonly>${course}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="trainer">Trainer:</label>
                            <input class="form-control" type="text" id="trainer" value="${trainer}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="date">Date:</label>
                            <input class="form-control" type="text" id="date" value="<tags:localDate date="${date}"/>"
                                   readonly>
                        </div>
                        <div class="form-group">
                            <label for="firstname">First Name:</label>
                            <input class="form-control" type="text" id="firstname" name="firstname" maxlength="20"
                                   value="${firstname}">
                        </div>
                        <div class="form-group">
                            <label for="lastname">Last Name:</label>
                            <input class="form-control" type="text" id="lastname" name="lastname" maxlength="20"
                                   value="${lastname}">
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input class="form-control" type="text" id="phone" name="phone" maxlength="20"
                                   onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                        </div>
                        <div class="form-group">
                            <label for="email">E-mail:</label>
                            <input class="form-control" type="text" id="email" name="email" maxlength="30">
                        </div>
                        <div class="form-group row">
                            <div class="col"></div>
                            <div class="col"></div>
                            <div class="col">
                                <button type="submit" class="btn btn-primary">OK</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="_footer.jsp"/>
    </footer>
</div>
</body>
</html>