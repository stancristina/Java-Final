package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String hello(Model model,
                        @RequestParam(value = "name", required = false, defaultValue = "World")String name,
                        @RequestParam(value = "age", required = false, defaultValue = "18") Integer age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hello";
    }
}
