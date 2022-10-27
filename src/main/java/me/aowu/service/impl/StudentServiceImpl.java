package me.aowu.service.impl;

import me.aowu.mapper.ArticleMapper;
import me.aowu.mapper.StudentMapper;
import me.aowu.pojo.Article;
import me.aowu.pojo.Student;
import me.aowu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public Student getStudentByID(int sid) {
        Student studentByID = studentMapper.getStudentByID(sid);
        return studentByID;
    }

    @Override
    public int setSelect(int cid, int sid) {


        Article articleByID = articleMapper.getByID(cid);

        //1.先检查毕设当前人数+1是否满员
        if (articleByID.getC_curr()+1>articleByID.getC_total())
            return 1;//满员

        //2.判断是否已经选择了毕设
        Student student= studentMapper.getStudentByID(sid);
        if (student.getS_select()>0){
            //减一
            articleMapper.minOneSub(student.getS_select());
        }
        //未满
        int setSelect = studentMapper.setSelect(cid, sid);
        int addOneSub = articleMapper.addOneSub(cid);

        //0 完成 2 未知错误看SPringboot后台
        return setSelect==addOneSub?0:2;
    }

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
