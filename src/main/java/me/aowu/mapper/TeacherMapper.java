package me.aowu.mapper;


import me.aowu.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper {

    List<Teacher> queryAll();
    Teacher queryByAccount(String t_account);
    Teacher getByID(int tid);

    int delByAccount(String t_account);

    int addTeacher(Teacher teacher);


}
