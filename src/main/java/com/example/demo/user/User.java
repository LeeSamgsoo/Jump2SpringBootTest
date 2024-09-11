package com.example.demo.user;

import com.example.demo.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE)
    private List<Article> articles;
}
