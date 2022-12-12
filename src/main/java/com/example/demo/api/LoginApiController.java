package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.ResultUtil;
import com.example.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public Result<Object> studentLogin(
            String name, String password,
            HttpServletRequest httpServletRequest
    ) throws Exception {
        Student checkNameAndPassword = studentService.findByNameAndPassword(name, password);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("name", checkNameAndPassword.getName());
        session.setAttribute("password", checkNameAndPassword.getPassword());
        return ResultUtil.success(checkNameAndPassword);
    }
}
