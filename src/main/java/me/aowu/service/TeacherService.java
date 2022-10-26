package me.aowu.service;

import me.aowu.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> queryAll();
    Teacher queryByAccount(String t_account);


    int delByAccount(String t_account);
    int addTeacher(Teacher teacher);

}
