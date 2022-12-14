package me.aowu.service;

import me.aowu.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryAll();
    List<Student> getStudentByName(String s_name);
    int addStudent(Student student);
    Student getStudentByAccount(String s_account);

    int setSelect(int cid,int sid);
    Student getStudentByID(int sid);


    int delByAccount(String s_account);
}
