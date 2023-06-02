<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Регистрация нового класса</title>
</head>

<body>
<div>
  <form:form method="POST" modelAttribute="classroomForm">
    <h2>Регистрация нового класса</h2>
    <div>
      <form:input type="text" path="classroomName" placeholder="Логин"
                  autofocus="true"></form:input>
      <form:errors path="classroomName"></form:errors>
        ${classroomNameError}
    </div>
    <div>
      <form:input type="text" path="classroomLocation" placeholder="Локация"
                  autofocus="true"></form:input>
      <form:errors path="classroomLocation"></form:errors>
        ${classroomLocationError}
    </div>
    <div>
      <form:input type="text" path="surname" placeholder="Фамилия"
                  autofocus="true"></form:input>
      <form:errors path="surname"></form:errors>
        ${surnameError}
    </div>
    <div>
      <form:input type="text" path="name" placeholder="Имя"
                  autofocus="true"></form:input>
      <form:errors path="name"></form:errors>
        ${nameError}
    </div>
    <div>
      <form:input type="text" path="patronymic" placeholder="Отчество"
      autofocus="true"></form:input>
      <form:errors path="patronymic"></form:errors>
      ${patronymicError}
    </div>
    <div>
      <form:input type="text"  path="email" placeholder="Почта"
      autofocus="true"></form:input>
      <form:errors path="email"></form:errors>
      ${emailError}
    </div>
    <br>
    <button type="submit">Зарегистрировать новый класс</button>
  </form:form>
  <br>
  <a href="/admin/">Вернуться</a>
</div>
</body>
</html>