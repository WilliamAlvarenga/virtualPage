package com.app.vpage.article.model;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@Size(min= 3, max =5000 , message = "Maximo de caractere para texto é 5000!")
	private String text;

}
