package application.controller;

import application.model.User;
import application.repository.impl.CompanyRepositoryImpl;
import application.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private CompanyRepositoryImpl companyRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("message", "");
        return "register";
    }

    @PostMapping("/user/save")
    public String save(Model model, User user) {
        userRepository.save(user);
        model.addAttribute("message", "Utilizatorul a fost creat");
        return "register";
    }

    @ModelAttribute("user/companies")
    public List populateDepartments()
    {
        return companyRepository.findAll();
    }

}
