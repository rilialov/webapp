<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="views/styles/main.css">
    <title>Create Course</title>
</head>
<body>
<div class="all">
    <header>
        <jsp:include page="../_header.jsp"></jsp:include>
    </header>
    <main>
        <h1>Create Course</h1>
        <form action="createCourse" method="post">
            <ul>
                <li>
                    <label for="vendor_id">Vendor:</label>
                    <input class="txtinput" type="text" id="vendor_id" name="vendor_id" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
                </li>
                <li>
                    <label for="course_code">Course code:</label>
                    <input class="txtinput" type="text" id="course_code" name="course_code">
                </li>
                <li>
                    <label for="course_name">Course name:</label>
                    <input class="txtinput" type="text" id="course_name" name="course_name">
                </li>
                <li class="button"><input type="submit" value="OK"></li>
            </ul>
        </form>
    </main>
    <footer>
        <jsp:include page="../_footer.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>