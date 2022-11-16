package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Teacher;
import org.springframework.data.jpa.repository.Query;


public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    @Query(nativeQuery=true, value = "SELECT * FROM teacher WHERE no = (SELECT MAX(no) FROM teacher)")
    public Teacher findTeacherByTopNo();
}