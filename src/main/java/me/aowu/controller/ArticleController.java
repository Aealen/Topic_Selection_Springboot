package me.aowu.controller;


import com.alibaba.fastjson.JSON;
import me.aowu.api.RetInfo;
import me.aowu.mapper.ArticleMapper;
import me.aowu.pojo.Article;
import me.aowu.pojo.Teacher;
import me.aowu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping
    public String queryAll(){
        List<Article> articles = articleService.queryAll();
        return JSON.toJSONString(articles);
    }

    @GetMapping("byid/{id}")
    public String byID(@PathVariable("id") int id){
        Article byID = articleService.getByID(id);
        return JSON.toJSONString(byID);
    }

    @GetMapping("bytid/{tid}")
    public String byTID(@PathVariable("tid") int tid){
        List<Article> byTID = articleService.getByTID(tid);
        return JSON.toJSONString(byTID);
    }


    @PostMapping("add")
    public String addArticle(int tid,String c_title,String c_content,String c_update,String c_curr,String c_total){
        Article article=new Article();
        article.setC_title(c_title);
        article.setC_content(c_content);
        article.setC_update(c_update);
        article.setC_curr(Integer.parseInt(c_curr));
        article.setC_total(Integer.parseInt(c_total));
        
        int articleID = articleService.addArticle(article);
        //获得刚增加的文章的主键ID

        int TCstatus = articleService.addInTC(tid, articleID);

        RetInfo retInfo = new RetInfo();
        if (TCstatus!=0){
            retInfo.setStatuss("ok");
        }else {
            retInfo.setStatuss("err");
        }
        retInfo.setDatas("articleID:"+articleID+"  TCStatus:"+TCstatus);

        return JSON.toJSONString(retInfo);
    }

    @DeleteMapping("del")
    public String delArticle(int t_id,int c_id){
        int delArticle = articleService.delArticle(c_id);
        int delFromTC = articleService.delFromTC(t_id, c_id);
        RetInfo retInfo = new RetInfo();
        if (delArticle==delFromTC && delFromTC==1){
            retInfo.setStatuss("ok");
            retInfo.setDatas("Success");
        }else {
            retInfo.setStatuss("err");
            retInfo.setDatas("Error");
        }

        return JSON.toJSONString(retInfo);
    }



}
