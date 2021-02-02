package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoItemController {
    public TodoData todoData() {
        return new TodoData();
    }

    @GetMapping("items")
    public String items() {
        return "items";
    }
}
