package com.example.demo.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "아이디를 입력해 주세요.")
    @Size(max = 25, message = "아이디가 제한길이를 넘었습니다.")
    private String username;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;

    @NotEmpty(message = "비밀번호 확인란을 입력해 주세요.")
    private String passwordComp;

    @NotEmpty(message = "이메일을 입력해 주세요.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
}
