<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Все классы</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
  <table>
    <thead>
    <th>Логин &ensp;</th>
    <th>Пароль &ensp;</th>
    <th>Локация &ensp;</th>
    <th>Фамилия &ensp;</th>
    <th>Имя &ensp;</th>
    <th>Отчество &ensp;</th>
    <th>Почта &ensp;</th>
    </thead>
    <c:forEach items="${allClassrooms}" var="classroom">
      <tr>
        <td>${classroom.classroomName} &ensp;</td>
        <td>${classroom.password} &ensp;</td>
        <td>${classroom.classroomLocation} &ensp;</td>
        <td>${classroom.surname} &ensp;</td>
        <td>${classroom.name} &ensp;</td>
        <td>${classroom.patronymic} &ensp;</td>
        <td>${classroom.email} &ensp;</td>
        <td>
          <form action="${pageContext.request.contextPath}/admin/classroom/all" method="post">
            <input type="hidden" name="classroomId" value="${classroom.id}"/>
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