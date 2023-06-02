<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Результаты прохождений студента</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>Номер зачётной книжки &ensp;</th>
        <th>Фамилия &ensp;</th>
        <th>Имя &ensp;</th>
        <th>Отчество &ensp;</th>
        <th>Номер группы &ensp;</th>
        <th>Дата прохождения &ensp;</th>
        <th>Результат(%) &ensp;</th>
        </thead>
        <c:forEach items="${studentScores}" var="student">
            <tr>
                <td>${student.studentID} &ensp;</td>
                <td>${student.studentSurname} &ensp;</td>
                <td>${student.studentName} &ensp;</td>
                <td>${student.studentPatronymic} &ensp;</td>
                <td>${student.studentGroup} &ensp;</td>
                <td>${student.studentScoreDate} &ensp;</td>
                <td>${student.studentScore} &ensp;</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/user/">Вернуться</a>
</div>
</body>
</html>










