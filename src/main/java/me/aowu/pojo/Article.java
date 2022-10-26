package me.aowu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private int cid;
    private String c_title;
    private String c_content;
    private String c_update;
    private String c_curr;
    private String c_total;
}
