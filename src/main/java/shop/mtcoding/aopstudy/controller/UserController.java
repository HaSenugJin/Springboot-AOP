package shop.mtcoding.aopstudy.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.aopstudy.config.annotation.LoginUser;
import shop.mtcoding.aopstudy.config.annotation.LoginUserResolver;
import shop.mtcoding.aopstudy.config.dto.JoinInDto;
import shop.mtcoding.aopstudy.model.User;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final HttpSession session;

    @GetMapping("/login")
    public String login() {
        User user = new User(1, "ssar", "1234", "0102222");
        session.setAttribute("principal", user);
        return "login ok";
    }

    @GetMapping("/user")
    public String userInfoNoAuth() {
        return "user ok";
    }

    @GetMapping("/user/v1") // 인증 필요 없음
    public String userInfo(User user) {
        return "vi username : " + user.getUsername();
    }

    @GetMapping("/auth/v2")
    public String authInfo(@LoginUser User user) { // 인증 필요함
        return "v2 username : " + user.getUsername();
    }

    @GetMapping("/auth/v3")
    public String authInfo22(@LoginUserResolver User user) { // 인증 필요함
        System.out.println(user.getUsername());
        return "v3 username : " + user.getUsername();
    }

    @PostMapping("/valid")
    public String join(@Valid JoinInDto joinInDto, BindingResult bindingResult){
        return "ok";
    }
}
