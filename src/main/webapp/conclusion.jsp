<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c2" %>
<c2:set var="lastInfo" value="${applicationScope.lastInfo}" />
<html>
<head>
    <title>Conclusion</title>
    <link rel="stylesheet" type="text/css" href="cssStyle/concStyle.css">
</head>
<body>
    <div>
        <header class="header">
            <h2>Lab №1</h2> <br> Ovchinnikov Ilya, P3221 <br> Var no
        </header>
    </div>
    <div class="zone">
        <h3> Result: ${lastInfo.getResult()}</h3> <br>
        <h3> X: ${lastInfo.getX()}</h3> <br>
        <h3> Y: ${lastInfo.getY()}</h3> <br>
        <h3> R: ${lastInfo.getR()}</h3> <br>
        <h3> Current time: ${lastInfo.getTime()}</h3> <br>
        <h3> Script time: ${lastInfo.getScriptTIme()}</h3> <br>
        <button class="bigButtons" onclick="redirectToIndex()">На главную</button>
    </div>
    <script>
        function redirectToIndex() {
            window.location.href = "index.jsp";
        }
    </script>
</body>
</html>
