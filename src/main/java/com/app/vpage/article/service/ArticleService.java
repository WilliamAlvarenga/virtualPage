package com.app.vpage.article.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.app.vpage.article.model.Article;
import com.app.vpage.article.repository.ArticleRepository;
import com.app.vpage.execptionhandler.BadRequestException;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	public List<Article> getAllArticles() {
		
		return articleRepository.findAll();
		
	}
	
	public Optional<Article> getArticleById(Long id) {

		return articleRepository.findById(id);		

	}

	public Article createArticle(Article article) {
		
		if(!ObjectUtils.isEmpty(article.getId())) {
			throw new BadRequestException("Id informado indevidamente: Informar id somente para atualização! ");
		}
		
		article.setMadeDate(Calendar.getInstance());
		article.setAproved(false);
				
		return articleRepository.save(article);
		
	}

	public void updateArticle(Article article, Long id) {

		Optional<Article>  savedArticle = articleRepository.findById(id);
		
		if(!savedArticle.isPresent()) {
			throw new BadRequestException("Artigo não encontrado na base de dados");
		}
				
		BeanUtils.copyProperties(article, savedArticle.get(),"id");
		
		articleRepository.save(savedArticle.get());
	}

	public void deleteArticleById(Long id) {
		// TODO Auto-generated method stub
		
	}

	

	

}
