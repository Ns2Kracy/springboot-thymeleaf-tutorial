package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(nativeQuery = true, value = "select * from student")
    List<Student> findAll();

    @Query(nativeQuery = true, value = "select * from student where name like ?1")
    List<Student> findByNameLike(String name);

    @Query(nativeQuery = true, value = "select * from student where name = {name}")
    Student findByName(String name);

    List<Student> findByNameAndPassword(String name, String password);

    @Query(nativeQuery = true, value = "select * from student where no = {no}")
    Student findByNo(String no);

    @Modifying
    @Query(nativeQuery = true, value = "update student set name = {name}, set no = {}, set where id = {id}")
    Student updateById(Integer id);

}
