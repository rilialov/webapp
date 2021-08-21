<%--@elvariable id="valid" type="java.lang"--%>
<%--@elvariable id="login" type="java.lang"--%>
<%--@elvariable id="error" type="java.lang"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/main.css"/>">
    <title>Main Page</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="WEB-INF/views/_header.jsp"/>
    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <div class="container-fluid border border-dark">
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="login">Login:</label>
                                <input class="form-control ${valid}" type="text" id="login" name="login"
                                       value="${login}"
                                       placeholder="Enter login">
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input class="form-control ${valid}" type="password" id="password" name="password"
                                       placeholder="Password">
                                <div class="invalid-feedback">${error}</div>
                            </div>
                            <div class="form-group row">
                                <div class="col"></div>
                                <div class="col"></div>
                                <div class="col"><button type="submit" class="btn btn-primary">OK</button></div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col"></div>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="WEB-INF/views/_footer.jsp"/>
    </footer>
</div>
</body>
</html>