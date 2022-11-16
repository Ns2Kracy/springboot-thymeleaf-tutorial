package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/list")
    public String list(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "/student/list";
    }

    @GetMapping("/student/{name}")
    public String findByNameLike(Model model, @PathVariable String name) {
        List<Student> students = studentService.findByNameLike(name);
        model.addAttribute("students", students);
        // 返回指定name的学生信息
        return "/student/list";
    }
}
