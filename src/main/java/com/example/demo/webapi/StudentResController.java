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

    @GetMapping("/getid/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        Student student = studentService.findById(id);
        student.setPassword("");
        return student;
    }

    @GetMapping("/getname?name={name}")
    public Student getByName(@PathVariable("name") String name){
        return studentService.findByName(name);
    }

    @GetMapping("/getno/{no}")
    public Student getByNo(@PathVariable("no") String no){
        return studentService.findByNo(no);
    }

    @PostMapping("/update")
    public Student update(Student student) {
        return studentService.Update(studentService.findById(student.getId()));
    }

    @PostMapping("/update/{id}")
    public Student updateById(@PathVariable("id") Integer id) {
        return studentService.updateById(id);
    }

    @DeleteMapping("/delete")
    public void delete(Student student) {
        studentService.Delete(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        studentService.DeleteById(id);
    }

}
