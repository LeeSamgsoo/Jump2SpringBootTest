package com.example.demo.article;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String articleList(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/create")
    public String articleCreate() {
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate(@RequestParam(value = "title") String title,
                                @RequestParam(value = "content") String content){
        this.articleService.create(title, content);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail(@PathVariable(value = "id") Integer id, Model model) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
}
