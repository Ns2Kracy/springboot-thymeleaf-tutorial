package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class StudentApiController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/list")
    public List<Student> list(HttpServletRequest httpServletRequest) throws Exception {
        if (!checkLogin(httpServletRequest)) {
            throw new Exception("Please login first");
        }
        return studentService.findAll();
    }

    private boolean checkLogin(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        String name = (String) session.getAttribute("name");
        return name != null && !name.equals("");
    }
}
