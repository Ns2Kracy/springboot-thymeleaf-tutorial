package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findByNameLike(String name) {
        return studentRepository.findByNameLike(name);
    }

    public List<Student> findByNameAndPassword(String name, String password) {
        return studentRepository.findByNameAndPassword(name, password);
    }

    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student Insert(Student student) {
        return studentRepository.save(student);
    }

    public Student Update(Student student) {
        return studentRepository.save(student);
    }

    public void Delete(Student student){
        studentRepository.delete(student);
    }

    public void DeleteById(Integer id){
        studentRepository.deleteById(id);
    }
}
