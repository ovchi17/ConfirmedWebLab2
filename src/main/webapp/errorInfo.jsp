<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c3" %>
<c3:set var="errorInfo" value="${applicationScope.errorInfo}" />
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" type="text/css" href="cssStyle/concStyle.css">
</head>
<body>
    <h3> Error message: ${errorInfo}</h3> <br>
    <button class="bigButtons" onclick="redirectToIndex()">На главную</button>
    <script>
        function redirectToIndex() {
            window.location.href = "index.jsp";
        }
    </script>
</body>
</html>
