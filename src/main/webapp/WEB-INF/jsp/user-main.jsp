<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Просмотр результатов прохождений</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h3> <sec:authentication property="principal.surname"/> <sec:authentication property="principal.name"/> <sec:authentication property="principal.patronymic"/></h3>
  <h4><a href="/user/scores/student">Результаты студента по номеру зачетки</a></h4>
  <h4><a href="/user/scores/studentgroup">Результаты студентов по номеру группы</a></h4>
  <br>
  <a href="/">Главная</a>
</div>
</body>
</html>