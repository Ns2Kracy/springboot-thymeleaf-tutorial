package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {

    @Autowired

    List<Student> findAll();
    Student findById(Integer id);

    List<Student> findByNameLike(String name);
    List<Student> findByNameAndPassword(String name, String password);
    Student findByName(String name);
    Student Insert(Student student);
    Student Update(Student student);

    void Delete(Student student);

    void DeleteById(Integer id);

    Student findByNo(String no);

    Student updateById(Integer id);

    Page<Student> findAll(Pageable pageable);

    public Page<Student> findAll(Example<Student> example, Pageable pageable);

}
