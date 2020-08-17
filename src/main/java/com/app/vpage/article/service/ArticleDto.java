package com.app.vpage.article.service;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ArticleDto {
	
	@NotEmpty(message = "Favor adicionar um título!")
	private String title;
	
	private String author;
	
	@NotEmpty(message = "Texto obrigatório!")
	private String text;

}
