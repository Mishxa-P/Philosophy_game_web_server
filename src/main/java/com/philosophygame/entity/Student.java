package com.philosophygame.entity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max = 20, message = "Не меньше 2 и не больше 20 знаков")
    private String studentID;

    @Size(min=2, max = 20, message = "Не меньше 2 и не больше 20 знаков")
    private String studentName;

    @Size(min=2, max = 20, message = "Не меньше 2 и не больше 20 знаков")
    private String studentSurname;

    private String studentPatronymic;

    private String studentGroup;

    private int studentScore;

    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date studentScoreDate;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStudentScoreDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(studentScoreDate);
    }

    public void setStudentScoreDate(Date studentScoreDate) {
        this.studentScoreDate = studentScoreDate;
    }

    @Override
    public String toString()
    {

        return "Student{" +
                "studentID=" + studentID +
                ", studentName=" + studentName +
                ", studentSurname='" + studentSurname +
                ", studentPatronymic=" + studentPatronymic +
                ", studentGroup=" + studentGroup +
                ", studentScoreDate=" + studentScoreDate +
                ", studentScore=" + studentScore +
                '}';
    }
}
