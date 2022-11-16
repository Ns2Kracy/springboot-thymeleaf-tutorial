package com.example.demo.service;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    @Test
    void findAll() {

        List<Student> students = studentService.findAll();
        students.forEach(System.out::println);
        assertNotNull(students);
    }

    @Test
    void findById() {
        Student students = studentService.findById(1);
        assertNotNull(students);
    }

    @Test
    void findByNameLike() {
        List<Student> students = studentService.findByNameLike("宁%");
        assertNotNull(students);
    }

    @Test
    void fineByNameAndPassword() {
        List<Student> students = studentService.findByNameAndPassword("宁坤", "ns2kracy");
        assertNotNull(students);
    }

    @Test
    void insert() {
        Student student = new Student();
        student.setName("张三");
        student.setPassword("ns2kracy");
        student.setSex(1);
        studentService.Insert(student);
        assertNotNull(student);

    }

    @Test
    void Update() {
        Student student = studentService.findById(2);
        student.setName("李四");
        studentService.Update(student);
        assertNotNull(student.getName());
    }

    @Test
    void delete() {
        Student student = studentService.findById(2);
        studentService.Delete(student);
        assertNotNull(student.getId());
    }
}