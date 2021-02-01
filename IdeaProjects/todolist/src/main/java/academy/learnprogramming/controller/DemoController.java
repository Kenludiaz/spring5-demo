package academy.learnprogramming.controller;

import academy.learnprogramming.Service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DemoController {

    private final DemoService service;
    @Autowired
    public DemoController(DemoService service, DemoService demoService) {
        this.service = demoService;
    }

    // Automatically adds response to body
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        String user = "Time";
        model.addAttribute( "userMessage", service.getHelloMessage(user));

        log.info("model = {}", model);

        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return service.getWelcomeMessage();
    }

}
