package com.app.vpage.article.model;



import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDto {
	
	@NotEmpty(message = "Favor adicionar um título!")
	private String title;
	
	@NotEmpty(message = "Favor informar o autor!")
	private String author;
	
	@NotEmpty(message = "Texto obrigatório!")
	private String text;

}
