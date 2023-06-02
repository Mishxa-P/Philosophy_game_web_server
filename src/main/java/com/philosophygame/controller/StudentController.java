package com.philosophygame.controller;

import com.philosophygame.entity.ClassroomRequest;
import com.philosophygame.entity.StudentRequest;
import com.philosophygame.service.ClassroomService;
import com.philosophygame.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/student")
    public String student() {
       return "student";
    }

    @PostMapping("/student")
    public ResponseEntity<Boolean> addStudent(@RequestBody StudentRequest newStudent) {
        if (studentService.saveStudent(newStudent))
        {
            return  ResponseEntity.status(HttpStatus.CREATED).body(true);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    @GetMapping("/classroom")
    public String classroom() {
        return "classroom";
    }

    @PostMapping("/classroom")
    public ResponseEntity<Boolean> checkClassroom(@RequestBody ClassroomRequest classroomRequest) {

        if (classroomService.checkClassroom(classroomRequest))
        {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
}
