package com.app.vpage.article.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.vpage.article.model.Article;
import com.app.vpage.article.service.ArticleService;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleControl {

	@Autowired
	ArticleService articleService;
		
	@GetMapping
	@Cacheable(value="articlesCache")
	public Page<?> getArticles(Pageable page, @RequestParam(name="author") Optional<String> author) {

		return articleService.getArticles(page, author);

	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable Long id) {
		
		Optional<Article> article = articleService.getArticleById(id);
		
			return	article.isPresent()?				
					ResponseEntity.ok(article.get()):
					ResponseEntity.noContent().build();
	}	
	
	
	@PostMapping
	@CacheEvict(value="articlesCache", allEntries = true)
	public ResponseEntity<?> createArticle(@Valid @RequestBody Article articleDTO) {
		
		Article article = articleService.createArticle(articleDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(article.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value="articlesCache", allEntries = true)
	public ResponseEntity<?> UpdateArticle(@PathVariable Long id,
							  @Valid @RequestBody Article article) {
		
		return ResponseEntity.ok(articleService.updateArticle(article, id));
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value="articlesCache", allEntries = true)
	public ResponseEntity<?> deleteArticle(@PathVariable @Valid Long id) {
		articleService.deleteArticleById(id);
		return ResponseEntity.ok().build();
	}
	
}
