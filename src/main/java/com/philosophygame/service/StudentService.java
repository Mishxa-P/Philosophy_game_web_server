package com.philosophygame.service;

import com.philosophygame.entity.Classroom;
import com.philosophygame.entity.Student;
import com.philosophygame.entity.StudentRequest;
import com.philosophygame.repository.ClassroomRepository;
import com.philosophygame.repository.StudentRepository;

import com.philosophygame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class StudentService{
    @PersistenceContext
    private EntityManager em;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Student findUserById(Long studentId) {
        Optional<Student> studentFromDb = studentRepository.findById(studentId);
        return studentFromDb.orElse(new Student());
    }

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public boolean saveStudent(StudentRequest studentRequest) {

        Classroom classroom = classroomRepository.findByClassroomName(studentRequest.getClassroomName());
        if (classroom == null) {
            return false;
        }
        if (!classroom.getPassword().equals(studentRequest.getClassroomPassword()))
        {
           return false;
        };

        Student studentEntity = new Student();
        studentEntity.setStudentID(studentRequest.getStudentID());
        studentEntity.setStudentSurname(studentRequest.getStudentSurname());
        studentEntity.setStudentName(studentRequest.getStudentName());
        studentEntity.setStudentPatronymic(studentRequest.getStudentPatronymic());
        studentEntity.setStudentGroup(studentRequest.getStudentGroup());
        studentEntity.setStudentScore(studentRequest.getStudentScore());
        LocalDateTime now = LocalDateTime.now();
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        studentEntity.setStudentScoreDate(currentDate);
        studentRepository.save(studentEntity);
        return true;
    }

    public boolean deleteUser(Long studentId) {
        if (studentRepository.findById(studentId).isPresent()) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }

    public boolean deleteAll() {
        studentRepository.deleteAll();
        return true;
    }

    public List<Student> studentScoreListByStudentID(String studentID) {
        return em.createQuery("SELECT u FROM Student u WHERE u.studentID = :paramId", Student.class)
                .setParameter("paramId", studentID).getResultList();
    }

    public List<Student> studentsListByGroup(String studentGroup) {
        return em.createQuery("SELECT u FROM Student u WHERE u.studentGroup = :paramGroup", Student.class)
                .setParameter("paramGroup", studentGroup).getResultList();
    }
}
