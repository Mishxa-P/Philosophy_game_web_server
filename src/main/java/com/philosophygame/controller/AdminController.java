package com.philosophygame.controller;

import com.philosophygame.entity.Classroom;
import com.philosophygame.entity.User;
import com.philosophygame.service.ClassroomService;
import com.philosophygame.service.StudentService;
import com.philosophygame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/")
    public String getMain(Model model) {
        return "admin-main";
    }

    @GetMapping("/allusers")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "all-users";
    }

    @PostMapping("/allusers")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin/allusers";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/admin/allusers";
    }


    @GetMapping("/classroom/all")
    public String classroomList(Model model) {
        model.addAttribute("allClassrooms", classroomService.allClassrooms());
        return "all-classrooms";
    }

    @PostMapping("/classroom/all")
    public String  deleteClassroom(@RequestParam(required = true, defaultValue = "" ) Long classroomId,
                                   @RequestParam(required = true, defaultValue = "" ) String action,
                                   Model model) {
        if (action.equals("delete")){
            classroomService.deleteClassroom(classroomId);
        }
        return "redirect:/admin/classroom/all";
    }

    @GetMapping("/classroom/registration")
    public String classroomRegistration(Model model) {
        model.addAttribute("classroomForm", new Classroom());

        return "classroom-registration";
    }

    @PostMapping("/classroom/registration")
    public String addClassroom(@ModelAttribute("classroomForm") @Valid Classroom classroomForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "classroom-registration";
        }
        if (!classroomService.saveClassroom(classroomForm)) {
            model.addAttribute("classroomNameError", "Класс с таким логином уже существует");
            return "classroom-registration";
        }

        return "redirect:/admin/classroom/all";
    }


    @GetMapping("/deleteallstudents")
    public String confirmStudentsDelete(Model model) {

        return "delete-all-students";
    }

    @PostMapping("/deleteallstudents")
    public String studentsDelete(Model model) {
        studentService.deleteAll();
        return "redirect:/admin/";
    }
}
