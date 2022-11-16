package com.example.demo.webapi;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return studentService.Insert(student);
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable("id") Integer id) {
        Student student = studentService.findById(id);
        student.setPassword("");
        return student;
    }

    @RequestMapping("/{name}")
    public Student getByName(@PathVariable("name") String name){
        return studentService.findByName(name);
    }

    @PutMapping("/update")
    public Student update(Student student) {
        return studentService.Update(student);
    }

    @DeleteMapping("/delete")
    public void delete(Student student) {
        studentService.Delete(student);
    }
}
