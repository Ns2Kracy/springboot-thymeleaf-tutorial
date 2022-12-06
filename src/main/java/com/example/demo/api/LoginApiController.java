package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.RUtil;
import com.example.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public Result studentLogin(String name, String password) throws Exception {
        Student checkNameAndPassword = studentService.findByNameAndPassword(name, password);
        return RUtil.success(checkNameAndPassword);
    }
}
