<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Все пользователи</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
  <table>
    <thead>
    <th>Логин &ensp;</th>
    <th>Пароль &ensp;</th>
    <th>Фамилия &ensp;</th>
    <th>Имя &ensp;</th>
    <th>Отчество &ensp;</th>
    <th>Почта &ensp;</th>
    <th>Роль &ensp;</th>
    </thead>
    <c:forEach items="${allUsers}" var="user">
      <tr>
        <td>${user.username} &ensp;</td>
        <td>${user.password} &ensp;</td>
        <td>${user.surname} &ensp;</td>
        <td>${user.name} &ensp;</td>
        <td>${user.patronymic} &ensp;</td>
        <td>${user.email} &ensp;</td>
        <td>
          <c:forEach items="${user.roles}" var="role">${role.name};&ensp; </c:forEach>
        </td>
        <td>
          <form action="${pageContext.request.contextPath}/admin/allusers" method="post">
            <input type="hidden" name="userId" value="${user.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Удалить</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <br>
  <a href="/admin/">Вернуться</a>
</div>
</body>
</html>