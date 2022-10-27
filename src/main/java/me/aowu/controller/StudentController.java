package me.aowu.controller;


import com.alibaba.fastjson.JSON;
import me.aowu.api.RetInfo;
import me.aowu.pojo.Article;
import me.aowu.pojo.Student;
import me.aowu.service.ArticleService;
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
    @GetMapping("byid/{id}")
    public  String getByAccount(@PathVariable("id") int id){
        Student studentByID = studentService.getStudentByID(id);
        return JSON.toJSONString(studentByID);
    }


    @PostMapping("addsubs")
    public String addsubs(int cid,int sid){

        RetInfo retInfo = new RetInfo();
        int setSelect = studentService.setSelect(cid, sid);
        if (setSelect==1){
            //满员了
            retInfo.setStatuss("err");
            retInfo.setDatas("满员了!!别选了!!");
        }else  if (setSelect==0){
            //满员了
            retInfo.setStatuss("ok");
            retInfo.setDatas("选择成功!!");
        }else  if (setSelect==2){
            //满员了
            retInfo.setStatuss("err");
            retInfo.setDatas("未知错误!!");
        }


        return  JSON.toJSONString(retInfo);

    }

    @PostMapping("add")
    public String add(String s_name,String s_gender,String s_college,String s_major,String s_class,String s_account,String s_password){

        //判断用户名是否存在
        if (studentService.getStudentByAccount(s_account)!=null) {
            retInfo.setStatuss("err");
            retInfo.setDatas("学工号已存在!!");
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
            retInfo.setStatuss("ok");
            retInfo.setDatas("添加用户成功!!");
        }else {
            retInfo.setStatuss("err");
            retInfo.setDatas("未知错误!请联系管理员!");
        }
        return JSON.toJSONString(retInfo);
    }

    @DeleteMapping("del/{s_account}")
    public String del(@PathVariable("s_account") String s_account){
        int i = studentService.delByAccount(s_account);
        if (i!=0){
            retInfo.setStatuss("ok");
            retInfo.setDatas("User Del : "+s_account);
        }
        return JSON.toJSONString(retInfo);
    }



}
