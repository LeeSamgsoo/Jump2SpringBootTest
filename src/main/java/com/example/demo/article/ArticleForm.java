package com.example.demo.article;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message = "제목을 입력해주세요.")
    @Size(max = 200, message = "제목의 글자 수가 초과되었습니다.")
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    @Size(message = "내용의 글자 수가 초과되었습니다.")
    private String content;
}
