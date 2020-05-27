package com.app.vpage.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.vpage.article.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
