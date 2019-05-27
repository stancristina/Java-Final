package application.controller;

import application.model.Employee;
import application.repository.impl.EmployeeRepositoryImpl;
import application.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmpController {

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;

    @GetMapping("/employee")
    public String showForm(Model model, Employee employee) {
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
    }
    model.addAttribute("action", "save");
    model.addAttribute("command", "Create Employee");
    model.addAttribute("oldEmployee", new Employee("First Name...", "Last Name...", 0L));
    return "employee";
    }

    @PostMapping("/save")
    public String save(Model model, Employee employee) {

        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }

        // validare campuri
        employee.setCreatedBy(UserPrincipal.getInstance().getLoggedUser().getId());
        employeeRepository.save(employee);
        return "redirect:/viewemp";
    }

    @GetMapping(value={"/viewemp"})
    public String viewemp(Model model, String filter ) {
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }
        List<Employee> employeeList = null;
        if(filter == null || filter.isEmpty()) {
            employeeList = employeeRepository.findAll();
            employeeList = employeeList.stream()
                    .filter(emp -> emp.getCreatedBy() == UserPrincipal.getInstance().getLoggedUser().getId())
                    .collect(Collectors.toList());
        } else {
            employeeList = new ArrayList<>();
            employeeList.addAll(employeeRepository.findByNameAndCreatedBy(filter,
                    UserPrincipal.getInstance().getLoggedUser().getId()));

            try {
                Long cnpLong = Long.parseLong(filter);
                employeeList.addAll(employeeRepository.findByCnpAndCreatedBy(cnpLong,
                        UserPrincipal.getInstance().getLoggedUser().getId()));
            } catch (Exception e) {
                System.out.println("Filtrul nu poate fi cnp");
            }

        }
        model.addAttribute("employeeList", employeeList);
        return "viewemp";
    }

    @GetMapping("/editemp/{id}")
    public String edit(Model model, Employee employee,@PathVariable  int id) {
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }

        Employee oldEmployee = employeeRepository.findById(id);
        model.addAttribute("command", "Edit employee");
        model.addAttribute("oldEmployee", oldEmployee);
        model.addAttribute("action", "update");
        return "employee";
    }

    @PostMapping("editemp/update")
    public String update(Model model, Employee employee) {
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }

        employeeRepository.update(employee);
        return "redirect:/viewemp";
    }

    @GetMapping("/deleteemp/{id}")
    public String delete(Model model,@PathVariable int id) {
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }

        employeeRepository.delete(id);
        return "redirect:/viewemp";
    }


}
