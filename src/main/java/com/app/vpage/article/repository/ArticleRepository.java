package com.app.vpage.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.vpage.article.model.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long>{

	@Query(value = "SELECT * FROM article WHERE aproved = TRUE ORDER BY id DESC" , nativeQuery = true)
	Page<Article> findApprovedArticle(Pageable pageable);
	
	@Query(value = "SELECT * FROM article WHERE aproved = TRUE AND author = ?1 ORDER BY id DESC" , nativeQuery = true)
	Page<Article> findByAuthor(String author, Pageable pageable);
	
	
}
