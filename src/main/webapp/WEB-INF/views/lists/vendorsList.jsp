<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Vendors List</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Vendors List</h1>
        <div class="left_side">
            <jsp:include page="../_left_menu.jsp" />
        </div>
        <div class="center">
            <table>
                <tr>
                    <th>Vendor name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%--@elvariable id="vendorsList" type="java.util.List"--%>
                <c:forEach items="${vendorsList}" var="vendor" >
                    <tr>
                        <td>${vendor.vendorName}</td>
                        <td>
                            <a href="updateVendor?vendor_id=${vendor.id}">Edit</a>
                        </td>
                        <td>
                            <a href="deleteVendor?vendor_id=${vendor.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/managers/createVendor"/>">Create a new vendor..</a>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>