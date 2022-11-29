package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentImplService implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    public Page<Student> findAll(Example<Student> example, Pageable pageable) {
        return studentRepository.findAll(example, pageable);
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }
    public Student insert(Student student) {
        return studentRepository.save(student);
    }
    public Student update(Student student){
        studentRepository.save(student);
        return student;
    }
    public Student updateById(Integer id, Student student){
        student.setId(id);
        studentRepository.save(student);
        return student;
    }
    public void DeleteById(Integer id){
        studentRepository.deleteById(id);
    }
}
