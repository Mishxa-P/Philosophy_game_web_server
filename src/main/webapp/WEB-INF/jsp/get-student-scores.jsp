<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Показать результаты студента</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="student">
        <h2>Показать результаты студента</h2>
        <div>
            <form:input type="text" path="studentID" placeholder="Номер зачётной книжки"
                        autofocus="true"></form:input>
        </div>
        <br>
        <button type="submit">Показать</button>
    </form:form>
    <br>
    <a href="/user/">Вернуться</a>
</div>
</body>
</html>