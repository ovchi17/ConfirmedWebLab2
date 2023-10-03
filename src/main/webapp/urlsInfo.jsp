<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="urlInfos" value="${applicationScope.urlInfos}" />
<c:set var="urlKeys" value="${applicationScope.urlKeys}" />
<html>
<head>
    <title>Url Page</title>
    <link rel="stylesheet" type="text/css" href="cssStyle/concStyle.css">
</head>
<body>
<div>
    <header class="header">
        <h2>Lab №2</h2> <br> Ovchinnikov Ilya, P3221 <br> Var №2167
    </header>
</div>
<table id="tableU">
    <tr>
        <th>URL</th>
        <th>COUNT</th>
    </tr>
    <c:forEach items="${urlKeys}" var="el">
        <tr>
            <td>${el}</td>
            <td>${urlInfos.get(el)}</td>
        </tr>
    </c:forEach>

</table>
<button class="bigButtons" onclick="redirectToIndex()">На главную</button>
<script>
    function redirectToIndex() {
        window.location.href = "index.jsp";
    }
</script>
</body>
</html>
