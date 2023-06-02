<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Очистить базу данных студентов</title>
</head>

<body>
<div>
  <form:form method="POST" >
    <h2>Очистить базу даннных студентов</h2>
    <br>
    <button type="submit">Подтвердить очистку</button>
  </form:form>
  <br>
  <a href="/admin/">Вернуться</a>
</div>
</body>
</html>