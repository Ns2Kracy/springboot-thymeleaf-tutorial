package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    /**
     * 查询所有
     * @return all teacher表的集合
     */
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    /**
     * 找出工号最大的教师.
     * @return 工号最大的教师的对象
     */
    public Teacher findByTopNo() {
        return teacherRepository.findTeacherByTopNo();
    }

    /**
     * 插入教师,不带主键
     */
    public void insert(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    /**
     * 修改教师带主键
     */
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    /**
     * 根据id删除教师
     */
    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }
}
