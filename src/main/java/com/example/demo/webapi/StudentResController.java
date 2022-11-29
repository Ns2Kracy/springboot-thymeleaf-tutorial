package com.example.demo.webapi;

import com.example.demo.core.PageUtil;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/webapi/student")
public class StudentResController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/list")
    public List<Student> getAll(){
        return studentService.findAll();
    }
    @PostMapping("/insert")
    public Student add(Student student) {
        return studentService.insert(student);
    }
    @GetMapping("/getid/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        Student student = studentService.findById(id);
        student.setPassword("");
        return student;
    }
    @PutMapping("/update/{id}")
    public Student update(Student student) {
        Student oldstudent = studentService.findById(student.getId());
        if (StringUtils.isEmpty(student.getPassword())) {
            student.setPassword(oldstudent.getPassword());
        }
        return studentService.update(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        studentService.DeleteById(id);
    }
    @GetMapping("/page")
    public PageUtil getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "10") Integer size,
                              @RequestParam(value = "name", defaultValue = "") String name) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Student> studentPage;

        if (StringUtils.isEmpty(name)) {
            Pageable pageable = PageRequest.of(page, size, sort);
            studentPage = studentService.findAll(pageable);
        } else {
            Student student = new Student();
            student.setName(name);

            Pageable pageable = PageRequest.of(0, 10, sort);

            ExampleMatcher matcher = ExampleMatcher.
                    matching().
                    withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Student> example = Example.of(student, matcher);

            studentPage = studentService.findAll(example, pageable);
        }
        return new PageUtil(studentPage.getContent(), studentPage.getTotalElements());
    }
}
