<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/main.css"/>">
    <title>Create Course</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp" />
    </header>
    <main>
        <h1>Create Course</h1>
        <form action="createCourse" method="post">
            <ul>
                <li>
                    <label for="vendor_id">Vendor:</label>
                    <input class="txt_input" type="text" id="vendor_id" name="vendor_id" maxlength="9" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                </li>
                <li>
                    <label for="course_code">Course code:</label>
                    <input class="txt_input" type="text" id="course_code" maxlength="9" name="course_code">
                </li>
                <li>
                    <label for="course_name">Course name:</label>
                    <textarea id="course_name" name="course_name" maxlength="148"></textarea>
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