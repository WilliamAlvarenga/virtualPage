package com.app.vpage.article.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.app.vpage.article.model.Article;
import com.app.vpage.article.repository.ArticleRepository;
import com.app.vpage.execptionhandler.BadRequestException;
import com.app.vpage.execptionhandler.NotContentException;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	
	public Page<Article> getArticles(Pageable pageable, Optional<String> author) {
	
		return author.isPresent() ? getArticleByAuthor(author.get() , pageable): getAllApprovedArticles(pageable);
		
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

	public Article updateArticle(Article article, Long id) {

		Optional<Article>  savedArticle = articleRepository.findById(id);
		
		article.setMadeDate(savedArticle.get().getMadeDate());		
		
		if(!savedArticle.isPresent()) {
			throw new BadRequestException("Artigo não encontrado na base de dados");
		}
				
		BeanUtils.copyProperties(article, savedArticle.get(),"id");
		
		return articleRepository.save(savedArticle.get());
	}

	public void deleteArticleById(Long id) {

		if (ObjectUtils.isEmpty(id) || !articleRepository.findById(id).isPresent()) {
			throw new BadRequestException("Não foi possivel encontrar o artigo!");
		}

		articleRepository.deleteById(id);

	}

	private Page<Article> getAllApprovedArticles(Pageable pageable) {
		
		Page<Article> articles = articleRepository.findByAproved(true, pageable);
		
		
		if(articles.getTotalElements()>0) {
			return articles;
		}
		
		throw new NotContentException();
	}

	
	private Page<Article> getArticleByAuthor(String author, Pageable pageable) {
		
		Page<Article> articles = articleRepository.findByAuthorAproved(author, pageable);
		
		if(articles.getTotalElements()>0) {
			return articles;
		}
		
		throw new NotContentException();
	}
}
