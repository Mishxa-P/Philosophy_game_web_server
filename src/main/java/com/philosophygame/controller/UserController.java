package com.philosophygame.controller;

import com.philosophygame.entity.Student;
import com.philosophygame.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String userList(Model model) {
        return "user-main";
    }

    @GetMapping("/scores/student")
    public String studentScores(Model model) {
        model.addAttribute("student", new Student());
        return "get-student-scores";
    }

    @PostMapping("/scores/student")
    public String showStudentScores(Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("studentScores", studentService.studentScoreListByStudentID(student.getStudentID()));
        return "student-scores";
    }


    @GetMapping("/scores/studentgroup")
    public String studentGroupScores(Model model) {
        model.addAttribute("student", new Student());
        return "get-student-group-scores";
    }

    @PostMapping("/scores/studentgroup")
    public String showSstudentGroupScores(Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("studentScores", studentService.studentsListByGroup(student.getStudentGroup()));
        return "student-scores";
    }

}
