package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(nativeQuery = true, value = "select * from student where name = {name}")
    Student findByName(String name);
}
