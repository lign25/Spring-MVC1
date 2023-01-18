package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //브라우저에서 요청 전달->
    // 스프링 컨테이너에서 관련 컨트롤러가 있는지 탐색->
    // 컨트롤러가 없으면 static파일에서 탐색
    @GetMapping("/")
    public String home() {
        return  "home";
    }
}
