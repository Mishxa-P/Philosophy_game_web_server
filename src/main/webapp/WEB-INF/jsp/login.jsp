<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Вход в аккаунт</title>
</head>

<body>
<sec:authorize access="isAuthenticated()">
  <% response.sendRedirect("/"); %>
</sec:authorize>
<div>
  <form method="POST" action="/login">
    <h2>Вход в систему</h2>
    <div>
      <input name="username" type="text" placeholder="Логин"
             autofocus="true"/>
      <input name="password" type="password" placeholder="Пароль"/>
      <button type="submit">Войти</button>
    </div>
    <br>
    <a href="/">Главная</a>
  </form>
</div>

</body>
</html>
