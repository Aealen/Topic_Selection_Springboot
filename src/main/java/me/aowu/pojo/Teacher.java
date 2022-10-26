package me.aowu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

private int tid;
private String t_name;
private String t_gender;
private String t_college;
private String t_capacity;
private String t_account;
private String t_password;
}
