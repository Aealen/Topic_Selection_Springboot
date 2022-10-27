package me.aowu.mapper;


import me.aowu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {

    List<Student> queryAll();
    List<Student> getStudentByName(String s_name);
    Student getStudentByAccount(String s_name);
    Student getStudentByID(int sid);

    int addStudent(Student student);


    int setSelect(int cid,int sid);


    int delByAccount(String s_account);

}
