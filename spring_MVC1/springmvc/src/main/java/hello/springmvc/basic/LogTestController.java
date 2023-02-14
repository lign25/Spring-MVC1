package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//문자를 반환하면 String이 바로 반환되는 애노테이션
@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name);

        log.trace("trace log = {}", name);
        log.trace("debug log = {}", name);
        log.trace("info log = {}", name);
        log.trace("warn log = {}", name);
        log.info("error log = {}", name);

        return "ok";
    }
}
