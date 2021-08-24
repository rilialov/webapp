<%--@elvariable id="title" type="java.lang"--%>
<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="vendor" type="com.test.webapp.model.Vendor"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>${title} Vendor</title>
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
                    <h2>${title} Vendor</h2>
                    <div class="row">
                        <div class="col container">
                            <form action="${create}Vendor" method="post">
                                <div class="form-group">
                                    <label for="vendorName">Vendor Name:</label>
                                    <input class="form-control" type="text" id="vendorName" name="vendorName"
                                           maxlength="20" value="${vendor.vendorName}">
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