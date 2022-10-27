package me.aowu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int sid;
    private String s_name;
    private String s_gender;
    private String s_college;
    private String s_major;
    private String s_class;
    private int s_select;
    private String s_account;
    private String s_password;
}
