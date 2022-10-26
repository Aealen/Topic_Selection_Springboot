package me.aowu.controller;


import com.alibaba.fastjson.JSON;
import me.aowu.api.RetInfo;
import me.aowu.pojo.Student;
import me.aowu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RetInfo retInfo;

    @GetMapping
    public String queryAll(){
        List<Student> students = studentService.queryAll();
        return JSON.toJSONString(students);
    }

    @GetMapping("byname/{username}")
    public String getByName(@PathVariable("username") String s_name){
        List<Student> studentByName = studentService.getStudentByName(s_name);
        return JSON.toJSONString(studentByName);
    }

    @GetMapping("byaccount/{account}")
    public  String getByAccount(@PathVariable("account") String s_account){
        Student studentByAccount = studentService.getStudentByAccount(s_account);
        return JSON.toJSONString(studentByAccount);
    }

    @PostMapping("add")
    public String add(String s_name,String s_gender,String s_college,String s_major,String s_class,String s_account,String s_password){

        //判断用户名是否存在
        if (studentService.getStudentByAccount(s_account)!=null) {
            retInfo.setStatus("err");
            retInfo.setData("用户名已存在!");
            return JSON.toJSONString(retInfo);
        }
        Student student=new Student();
        student.setS_name(s_name);
        student.setS_gender(s_gender);
        student.setS_college(s_college);
        student.setS_class(s_class);
        student.setS_major(s_major);
        student.setS_account(s_account);
        student.setS_password(s_password);

        int i = studentService.addStudent(student);
        if (i!=0){
            retInfo.setStatus("ok");
            retInfo.setData(String.valueOf(i));
        }
        return JSON.toJSONString(retInfo);
    }



}
