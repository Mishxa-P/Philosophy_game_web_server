package com.philosophygame.entity;

public class StudentRequest {

    private String classroomName;

    private String classroomPassword;

    private String studentID;

    private String studentName;

    private String studentSurname;

    private String studentPatronymic;

    private String studentGroup;

    private int studentScore;

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomPassword() {
        return classroomPassword;
    }

    public void setClassroomPassword(String classroomPassword) {
        this.classroomPassword = classroomPassword;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentPatronymic() {
        return studentPatronymic;
    }

    public void setStudentPatronymic(String studentPatronymic) {
        this.studentPatronymic = studentPatronymic;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }
}
