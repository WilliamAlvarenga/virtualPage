package com.app.vpage.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.vpage.article.model.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long>{
	
	Page<Article> findByAproved(Boolean aproved, Pageable pageable);
	
	@Query(value = "SELECT a FROM Article a WHERE a.aproved = true AND a.author = ?1")
	Page<Article> findByAuthorAproved(String author, Pageable pageable);
	
	
}
