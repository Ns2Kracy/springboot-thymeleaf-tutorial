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
        return studentRepository.Update(student);
    }

    public void Delete(Student student){
        studentRepository.delete(student);
    }

    public void DeleteById(Integer id){
        studentRepository.deleteById(id);
    }

    public Student findByNo(String no) {
        return studentRepository.findByNo(no);
    }

    public Student updateById(Integer id) {
        return studentRepository.updateById(id);
    }
}
