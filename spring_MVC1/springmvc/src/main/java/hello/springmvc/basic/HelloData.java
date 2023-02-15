package hello.springmvc.basic;

import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
public class HelloData {
    private String username;
    private int age;

}
