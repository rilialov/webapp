<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Vendors List</title>
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
                    <h2>Vendors List</h2>
                    <table class="table table-bordered table-striped">
                        <thead class="thead-light">
                        <tr>
                            <th>Vendor name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <%--@elvariable id="vendorsList" type="java.util.List"--%>
                        <c:forEach items="${vendorsList}" var="vendor">
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
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp"/>
    </footer>
</div>
</body>
</html>