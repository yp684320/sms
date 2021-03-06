package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    @Query(value = "update tb_article SET state='1' WHERE id=?",
            nativeQuery = true)
    @Modifying
        //写操作需要添加
    void examine(String articleId);

    @Query(value = "UPDATE tb_article SET thumbup = thumbup + 1 WHERE id = ?",
            nativeQuery = true)
    @Modifying
    void thumbup(String articleId);
}
