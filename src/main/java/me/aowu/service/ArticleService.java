package me.aowu.service;

import me.aowu.pojo.Article;

import java.util.List;

public interface ArticleService {
    int addArticle(Article article);
    int addInTC(int tid,int cid);

    List<Article> queryAll();


    int delFromTC(int t_id,int c_id);
    int delArticle(int cid);
}
