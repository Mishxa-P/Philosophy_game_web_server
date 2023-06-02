package com.philosophygame.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2, max = 20, message = "Не меньше 2 и не больше 20 знаков")
    private String classroomName;
    @Size(min=2, max = 100, message = "Не меньше 2 и не больше 100 знаков")
    private String classroomLocation;
    @Size(min=2, max = 20, message = "Не меньше 2 и не больше 20 знаков")
    private String name;
    @Size(min=2, max = 20, message = "Не меньше 2 и не больше 20 знаков")
    private String surname;
    @Size(max = 20, message = "Не больше 20 знаков")
    private String patronymic;
    @Size(max = 50, message = "Не больше 50 знаков")
    private String email;
    @Size(max = 20, message = "Не больше 20 знаков")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomLocation() {
        return classroomLocation;
    }

    public void setClassroomLocation(String classroomLocation) {
        this.classroomLocation = classroomLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
