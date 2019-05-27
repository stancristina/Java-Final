package application.controller;

import application.model.User;
import application.repository.impl.UserRepositoryImpl;
import application.security.UserPrincipal;
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

    @PostMapping("/user/register")
    public String save(Model model, User user) {
        List<User> userExists = userRepository.findByUsername(user.getUsername());
        List<User> userExists2 = userRepository.findByCompany(user.getCompany());

        if (user.getUsername() == null ||
                user.getPassword() == null ||
                user.getCompany() == null) {
            model.addAttribute("message", "All fields are mandatory");
            return "register";
        }

        if (userExists != null && !userExists.isEmpty()) {
            model.addAttribute("message", "There is already a user registered with this name!");
            return "register";
        }

        if (userExists2 != null && !userExists2.isEmpty()) {
            model.addAttribute("message", "There is already a user registered with this company!");
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("message", "User has been registered successfully!");
        return "register";
    }

    @GetMapping(value={"/", "/user/login"})
    public String login(Model model) {
        model.addAttribute("message", "");
        return "login";
    }

    @PostMapping("/user/login")
    public String login(Model model, User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            model.addAttribute("message", "All fields are mandatory");
            return "login";
        }

        List<User> userList = userRepository.findByUsername(user.getUsername());
        if(userList == null || userList.size() != 1) {
            model.addAttribute("message", "Username is not valid");
            return "login";
        }

        if(!user.getPassword().equals(userList.get(0).getPassword())) {
            model.addAttribute("message", "Password is wrong");
            return "login";
        }

        UserPrincipal.getInstance().setLoggedUser(userList.get(0));
        return "redirect:/employee";
    }

    @GetMapping("/user/logout")
    public String logout(Model model) {
        UserPrincipal.getInstance().setLoggedUser(null);
        return "redirect:/user/login";
    }


}