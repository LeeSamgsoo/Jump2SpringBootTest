package com.example.demo.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String userCreate(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String userCreate(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!userCreateForm.getPassword().equals(userCreateForm.getPasswordComp())) {
            bindingResult.rejectValue("passwordComp", "passwordIncorrect", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return "signup_form";
        }
        try{
            this.userService.create(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());
        } catch (DataIntegrityViolationException e) {
               e.printStackTrace();
               bindingResult.reject("signupFailed", "이미 등록된 사용자 입니다.");
               return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupError", e.getMessage());
            return "signup_form";
        }
        return "redirect:/article/list";
    }
}
