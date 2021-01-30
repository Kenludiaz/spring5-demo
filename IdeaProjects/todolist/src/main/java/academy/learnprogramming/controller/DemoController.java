package academy.learnprogramming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    // Automatically adds response to body
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
