<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="student" type="com.test.webapp.model.Student"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Student</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp"/>
    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <jsp:include page="../_left_menu.jsp"/>
                </div>
                <div class="col-10">
                    <h2>Edit Student</h2>
                    <div class="row">
                        <div class="col container">
                            <form action="${create}Student" method="post">
                                <div class="form-group">
                                    <label for="firstname">First Name:</label>
                                    <input class="form-control" type="text" id="firstname" name="firstname"
                                           value="${student.firstName}" maxlength="20">
                                </div>
                                <div class="form-group">
                                    <label for="lastname">Last Name:</label>
                                    <input class="form-control" type="text" id="lastname" name="lastname"
                                           value="${student.lastName}" maxlength="20">
                                </div>
                                <div class="form-group">
                                    <label for="phone">Phone:</label>
                                    <input class="form-control" type="text" id="phone" name="phone"
                                           value="${student.phone}" maxlength="20"
                                           onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                                </div>
                                <div class="form-group">
                                    <label for="email">E-mail:</label>
                                    <input class="form-control" type="text" id="email" name="email"
                                           value="${student.email}" maxlength="30">
                                </div>
                                <button type="submit" class="btn btn-primary">OK</button>
                            </form>
                        </div>
                        <div class="col"></div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp"/>
    </footer>
</div>
</body>
</html>