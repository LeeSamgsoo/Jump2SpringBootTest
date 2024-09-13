package com.example.demo;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.article.ArticleService;
import com.example.demo.user.SiteUser;
import com.example.demo.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {
	@Test
	void contextLoads() {
	}
}
