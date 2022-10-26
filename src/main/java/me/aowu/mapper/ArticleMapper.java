package me.aowu.mapper;


import me.aowu.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {
    int addArticle(Article article);
    int addInTC(int t_id,int c_id);

    List<Article> queryALl();

    int delFromTC(int t_id,int c_id);
    int delArticle(int cid);

}
