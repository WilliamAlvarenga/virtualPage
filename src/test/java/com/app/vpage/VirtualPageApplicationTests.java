package com.app.vpage;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.vpage.article.model.ArticleDto;


@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
class VirtualPageApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllArticle() {
		int response = get("/article").andReturn().getStatusCode();

		int[] listExpected = { 200, 204 };

		assertThat(listExpected).contains(response);

	}

	@Test
	public void addArticle() {
		
		ArticleDto testArticle = new ArticleDto("Teste Titulo", "Autor Test", "texto de test");
		
		int response = given()
						.contentType("application/json")
						.accept("*/*")
						.body(testArticle)
						.when().post("article")
						.andReturn()
						.getStatusCode();		
	
		assertEquals(201, response);			
			
	}
}
