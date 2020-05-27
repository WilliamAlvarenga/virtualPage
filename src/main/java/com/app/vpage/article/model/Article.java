package com.app.vpage.article.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
@Entity
@Table(name="article")
@Data
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Favor adicionar um título!")
	private String title;
	
	@Column(name="made_date")
	private Calendar madeDate;
	
	private String author;
	
	@NotEmpty(message = "Texto obrigatório!")
	private String text;
	//private String image;
	private Boolean aproved;
	
	
}
