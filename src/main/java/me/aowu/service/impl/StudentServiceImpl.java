package me.aowu.service.impl;

import me.aowu.mapper.StudentMapper;
import me.aowu.pojo.Student;
import me.aowu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentByAccount(String s_account) {
        Student studentByAccount = studentMapper.getStudentByAccount(s_account);
        return studentByAccount;
    }

    @Override
    public int delByAccount(String s_account) {
        int i = studentMapper.delByAccount(s_account);
        return i;
    }

    @Override
    public List<Student> getStudentByName(String s_name) {
        List<Student> studentByName = studentMapper.getStudentByName(s_name);
        return studentByName;
    }

    @Override
    public int addStudent(Student student) {
        int i = studentMapper.addStudent(student);
        return i;
    }

    @Override
    public List<Student> queryAll() {
        List<Student> students = studentMapper.queryAll();
        return students;
    }


}
