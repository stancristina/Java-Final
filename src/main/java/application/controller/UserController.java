package application.controller;

import application.model.User;
import application.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepositoryImpl userRepository;

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("message", "");
        return "register";
    }

    @PostMapping("/user/save")
    public String save(Model model, User user) {
        List<User> userExists = userRepository.findByUsername(user.getUsername());
        List<User> userExists2 = userRepository.findByCompany(user.getCompany());

        if(user.getUsername() == null ||
           user.getPassword() == null ||
           user.getCompany() == null) {
            model.addAttribute("message", "All fields are mandatory");
            return "register";
        }

        if(userExists != null && !userExists.isEmpty()) {
            model.addAttribute("message", "There is already a user registered with this name!");
            return "register";
        }

        if(userExists2 != null && !userExists2.isEmpty()) {
            model.addAttribute("message", "There is already a user registered with this company!");
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("message", "User has been registered successfully!");
        return "register";
    }
}
