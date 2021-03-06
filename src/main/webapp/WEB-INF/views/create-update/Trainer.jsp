<%--@elvariable id="title" type="java.lang"--%>
<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="trainer" type="com.test.webapp.entity.Trainer"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>${title} Trainer</title>
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
                    <h2>${title} Trainer</h2>
                    <div class="row">
                        <div class="col container">
                            <form action="${create}Trainer" method="post">
                                <div class="form-group">
                                    <label for="firstname">First Name:</label>
                                    <input class="form-control" type="text" id="firstname" name="firstname"
                                           maxlength="20" value="${trainer.firstName}">
                                </div>
                                <div class="form-group">
                                    <label for="lastname">Last Name:</label>
                                    <input class="form-control" type="text" id="lastname" name="lastname"
                                           maxlength="20" value="${trainer.lastName}">
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