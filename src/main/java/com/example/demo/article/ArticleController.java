package com.example.demo.article;

import com.example.demo.user.SiteUser;
import com.example.demo.user.UserService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/list")
    public String articleList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);
        return "article_list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm) {
        return "article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal){
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        SiteUser user = this.userService.getUser(principal.getName());
        if (user == null) {
            bindingResult.reject("createError", "user not found");
            return "article_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent(), user);
        return "redirect:/article/list";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail(@PathVariable(value = "id") Integer id, Model model) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
}
