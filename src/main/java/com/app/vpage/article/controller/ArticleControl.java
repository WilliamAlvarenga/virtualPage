package com.app.vpage.article.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.vpage.article.model.Article;
import com.app.vpage.article.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleControl {

	@Autowired
	ArticleService articleService;
	
	@GetMapping
	public ResponseEntity<?> getArticles() {
		
		List<Article> listArticle = articleService.getAllArticles();
		
		return ObjectUtils.isEmpty(listArticle)?
					ResponseEntity.noContent().build():
					ResponseEntity.ok(listArticle);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable Long id) {
		
		Optional<Article> article = articleService.getArticleById(id);
		
			return	article.isPresent()?				
					ResponseEntity.ok(article.get()):
					ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> createArticle(@Valid @RequestBody Article articleDTO) {
		
		Article article = articleService.createArticle(articleDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(article.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public void changeArticle(@PathVariable Long id,
							  @Valid @RequestBody Article article) {
		articleService.updateArticle(article, id);
	}
	
	@DeleteMapping
	public void deleteArticle(@PathVariable Long id) {
		articleService.deleteArticleById(id);
	}
	
}
