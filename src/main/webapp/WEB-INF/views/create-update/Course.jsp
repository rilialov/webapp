<%--@elvariable id="title" type="java.lang"--%>
<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="course" type="com.test.webapp.model.Course"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>${title} Course</title>
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
                    <h2>${title} Course</h2>
                    <div class="row">
                        <div class="col container">
                            <form action="${create}Course" method="post">
                                <div class="form-group">
                                    <label for="vendor_id">Vendor:</label>
                                    <%--@elvariable id="vendorsList" type="java.util.List"--%>
                                    <select class="form-control" id="vendor_id" name="vendor_id">
                                        <c:forEach items="${vendorsList}" var="vendor">
                                            <%--@elvariable id="vendor" type="com.test.webapp.model.Vendor"--%>
                                            <option value="${vendor.id}">${vendor.vendorName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="course_code">Course code:</label>
                                    <input class="form-control" type="text" id="course_code" name="course_code"
                                           value="${course.courseCode}" maxlength="9">
                                </div>
                                <div class="form-group">
                                    <label for="course_name">Course name:</label>
                                    <textarea class="form-control" id="course_name" name="course_name"
                                              maxlength="148">${course.courseName}</textarea>
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