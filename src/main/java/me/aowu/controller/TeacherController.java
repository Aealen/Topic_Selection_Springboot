package me.aowu.controller;


import com.alibaba.fastjson.JSON;
import me.aowu.api.RetInfo;
import me.aowu.pojo.Teacher;
import me.aowu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RetInfo retInfo;

    @GetMapping
    public String  queryAll(){
       List<Teacher> teacherList= teacherService.queryAll();
       return JSON.toJSONString(teacherList);
    }

    @GetMapping("byaccount/{account}")
    public String byaccount(@PathVariable("account") String account){
        Teacher teacher = teacherService.queryByAccount(account);
        return JSON.toJSONString(teacher);
    }

    @PostMapping("add")
    public String add(String t_name,String t_gender,String t_college,String t_capacity,String t_account,String t_password){

        if (teacherService.queryByAccount(t_account)!=null){
            retInfo.setStatuss("err");
            retInfo.setDatas("学工号已存在!!");
            return JSON.toJSONString(retInfo);
        }
        Teacher teacher = new Teacher();
        teacher.setT_account(t_account);
        teacher.setT_name(t_name);
        teacher.setT_gender(t_gender);
        teacher.setT_college(t_college);
        teacher.setT_capacity(t_capacity);
        teacher.setT_password(t_password);

        int add = teacherService.addTeacher(teacher);
        if (add!=0){
            retInfo.setStatuss("ok");
            retInfo.setDatas("添加用户成功!!");
        }else {
            retInfo.setStatuss("err");
            retInfo.setDatas("未知错误!请联系管理员!");
        }
        return JSON.toJSONString(retInfo);
    }

    @DeleteMapping("del/{account}")
    public String delByAccount(@PathVariable("account") String account){
        int i = teacherService.delByAccount(account);
        if (i!=0){
            retInfo.setStatuss("ok");
            retInfo.setDatas("Del User :" + account);
        }else {
            retInfo.setStatuss("err");
            retInfo.setDatas("No Such account exist!");
        }

        return JSON.toJSONString(retInfo);
    }

}
