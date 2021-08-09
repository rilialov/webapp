<%--@elvariable id="create" type="java.lang"--%>
<%--@elvariable id="course" type="com.test.webapp.model.Course"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <title>Edit Course</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Edit Course</h1>
        <form action="${create}Course" method="post">
            <ul>
                <li>
                    <label for="vendor_id">Vendor:</label>
                    <%--@elvariable id="vendorsList" type="java.util.List"--%>
                    <select id="vendor_id" name="vendor_id">
                        <c:forEach items="${vendorsList}" var="vendor" >
                            <%--@elvariable id="vendor" type="com.test.webapp.model.Vendor"--%>
                            <option value="${vendor.id}">${vendor.vendorName}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="course_code">Course code:</label>
                    <input class="txt_input" type="text" id="course_code" name="course_code" value="${course.courseCode}" maxlength="9">
                </li>
                <li>
                    <label for="course_name">Course name:</label>
                    <textarea id="course_name" name="course_name" maxlength="148">${course.courseName}</textarea>
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