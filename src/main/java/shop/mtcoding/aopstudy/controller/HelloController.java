package shop.mtcoding.aopstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.aopstudy.config.annotation.Hello;

@RestController
public class HelloController {

    @GetMapping("/v1")
    public String v1(){
        return "v1";
    }

    @Hello
    @GetMapping("/v2")
    public String v2(String username){
        System.out.println("username : 값 변경? : " + username);
        return "v2";
    }
}
