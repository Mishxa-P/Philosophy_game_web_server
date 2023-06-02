<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Администрирование</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h3> <sec:authentication property="principal.surname"/> <sec:authentication property="principal.name"/> <sec:authentication property="principal.patronymic"/></h3>
    <h4><a href="/admin/allusers">Список пользователей</a></h4>
    <h4><a href="/admin/registration">Зарегистрировать нового пользователя</a></h4>
    <h4><a href="/admin/classroom/all">Список классов</a></h4>
    <h4><a href="/admin/classroom/registration">Зарегистрировать новый класс</a></h4>
    <h4><a href="/admin/deleteallstudents">Очистить базу данных студентов</a></h4>
  <br>
  <a href="/">Главная</a>
</div>
</body>
</html>