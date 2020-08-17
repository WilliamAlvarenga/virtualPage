package com.app.vpage.article.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.app.vpage.article.service.ArticleDto;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="article")
@Getter
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Setter
	@NotEmpty(message = "Favor adicionar um título!")
	private String title;
	
	@Column(name="made_date")
	private Calendar madeDate;
	
	@Setter
	private Calendar updated;
	
	private String author;
	
	@Setter
	@NotEmpty(message = "Texto obrigatório!")
	private String text;
	//private String image;
	private Boolean aproved;
	
	public  Article dtoToArticle(ArticleDto articleDto) {
				
		this.aproved = false;
		this.madeDate = Calendar.getInstance();

		this.title = articleDto.getTitle();
		this.author = articleDto.getAuthor();
		this.text = articleDto.getText();
			   
		return this;
	}
	
	
}
