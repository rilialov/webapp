<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="vendor" type="com.test.webapp.model.Vendor"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Vendor</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Edit Vendor</h1>
        <form action="${create}Vendor" method="post">
            <ul>
                <li>
                    <label for="vendorName">Vendor Name:</label>
                    <input class="txt_input" type="text" id="vendorName" name="vendorName" maxlength="20" value="${vendor.vendorName}">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>