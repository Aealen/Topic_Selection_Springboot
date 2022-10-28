package me.aowu.service.impl;

import me.aowu.mapper.TeacherMapper;
import me.aowu.pojo.Teacher;
import me.aowu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher getByID(int tid) {
        Teacher byID = teacherMapper.getByID(tid);
        return byID;
    }

    @Override
    public int addTeacher(Teacher teacher) {
        int add = teacherMapper.addTeacher(teacher);
        return add;
    }

    @Override
    public Teacher queryByAccount(String t_account) {
        Teacher teacher = teacherMapper.queryByAccount(t_account);
        return teacher;
    }

    @Override
    public int delByAccount(String t_account) {
        int i = teacherMapper.delByAccount(t_account);
        return i;
    }

    @Override
    public List<Teacher> queryAll() {
        List<Teacher> teacherList=teacherMapper.queryAll();
        return teacherList;
    }
}
