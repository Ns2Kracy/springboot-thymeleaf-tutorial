package com.example.demo.service;

import com.example.demo.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TeacherServiceTest {
    @Resource
    private TeacherService teacherService;

    @Test
    public void findAll() {
        List<Teacher> all = teacherService.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void findByTopTeacher() {
        Teacher topTeacherNumber = teacherService.findByTopNo();
        System.out.println(topTeacherNumber);
    }

    @Test
    public void delete() {
        teacherService.delete(2);
    }

    @Test
    public void update() {
        Teacher teacher = new Teacher();
        teacher.setSex(1);
        teacher.setId(1);
        teacherService.update(teacher);
    }

    @Test

    public void insert() {
        Teacher teacher = new Teacher();
        teacher.setSex(1);
        teacher.setName("郑十");
        teacher.setNo("2019001");
        teacherService.insert(teacher);
    }
}
