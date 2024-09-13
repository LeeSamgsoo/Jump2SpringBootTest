package com.example.demo.article;

import com.example.demo.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public void create(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        articleRepository.save(article);
    }

    public Article getArticle(Integer id) {
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }
}
