package me.aowu.service.impl;

import me.aowu.mapper.ArticleMapper;
import me.aowu.pojo.Article;
import me.aowu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int addOneSub(int cid) {
        int i = articleMapper.addOneSub(cid);
        return i;
    }

    @Override
    public int minOneSub(int cid) {
        int i = articleMapper.minOneSub(cid);
        return i;
    }

    @Override
    public Article getByID(int id) {
        Article byID = articleMapper.getByID(id);
        return byID;
    }

    @Override
    public int delFromTC(int t_id, int c_id) {
        int i = articleMapper.delFromTC(t_id, c_id);
        return i;
    }

    @Override
    public int delArticle(int cid) {
        int i = articleMapper.delArticle(cid);
        return i;
    }

    @Override
    public List<Article> queryAll() {
        List<Article> articles = articleMapper.queryALl();
        return articles;
    }

    @Override
    public int addInTC(int tid, int cid) {
        int i = articleMapper.addInTC(tid, cid);
        return i;
    }
    @Override
    public int addArticle(Article article){
        articleMapper.addArticle(article);
        //返回自增后的主键ID
        return article.getCid();
    }





}
