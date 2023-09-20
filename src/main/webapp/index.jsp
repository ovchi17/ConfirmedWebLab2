<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="res" value="${applicationScope.res}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lab1</title>

    <script src="js/CheckInput.js"></script>
    <script src="js/NullTable.js"></script>
    <script src="js/RequestHandler.js"></script>
    <script src="js/Listeners.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="cssStyle/mainStyle.css">
</head>
<body>
<div>
    <header class="header">
        <h2>Lab №1</h2> <br> Ovchinnikov Ilya, P3221 <br> Var no
    </header>
</div>
<div class="workZone">
    <div class="container">
        <div class="XYcoord">
            <img src="jpg/xyCoord.png" alt="Граф">
        </div>
        <form novalidate name="simpleForm" onsubmit="confirmValues(); return false;">
            <div id="form">
                <div id="structForm">
                    <div class="buttons-container" id="buttonsList">
                        <label for="buttonsList">Изменение по X:</label>
                        <button type="button" class="button" data-value="-2">-2</button>
                        <button type="button" class="button" data-value="-1.5">-1.5</button>
                        <button type="button" class="button" data-value="-1">-1</button>
                        <button type="button" class="button" data-value="-0.5">-0.5</button>
                        <button type="button" class="button" data-value="0">0</button>
                        <button type="button" class="button" data-value="0.5">0.5</button>
                        <button type="button" class="button" data-value="1">1</button>
                        <button type="button" class="button" data-value="1.5">1.5</button>
                        <button type="button" class="button" data-value="2">2</button>
                    </div>
                    <div id="y-input">
                        <label for="y-input">Изменение по Y (-5 ... 5):</label>
                        <input type="text" class="y-text" maxlength="7" id="y-value" name="y-value" oninput="careInput(event)" required>
                    </div>
                    <div id="r-input">
                        <label for="r-input">Изменение по R:</label>
                        <input type="radio" class="r-radio" name="r-value" value="1"> 1
                        <input type="radio" class="r-radio" name="r-value" value="1.5"> 1.5
                        <input type="radio" class="r-radio" name="r-value" value="2" checked> 2
                        <input type="radio" class="r-radio" name="r-value" value="2.5"> 2.5
                        <input type="radio" class="r-radio" name="r-value" value="3"> 3
                    </div>
                </div>
                <input type="submit" class="bigButtons" name="submitButton" value="Подтвердить">
                <section id="checkInput" class="checkInput">

                </section>
            </div>
        </form>

    </div>
</div>

<div id="resultTable">
    <input type="submit" class="bigButtons" id="clearTable" value="Очистить" onclick=" nullTable()">
    <table id="table">
        <tr>
            <th>Result</th>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Current Time</th>
            <th>Script time</th>
        </tr>
        <c:forEach items="${res}" var="el">
            <tr>
                <td>${el.getResult()}</td>
                <td>${el.getX().toString()}</td>
                <td>${el.getY().toString()}</td>
                <td>${el.getR().toString()}</td>
                <td>${el.getTime()}</td>
                <td>${el.getScriptTIme()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
