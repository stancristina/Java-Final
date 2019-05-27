package application.controller;

import application.model.Holiday;
import application.repository.impl.HolidayRepositoryImpl;
import application.security.UserPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class HolidayController {

    private HolidayRepositoryImpl holidayRepository;

    @GetMapping ("/holiday")
    public String showForm(Model model, Holiday holiday){
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        model.addAttribute("action", "save");
        model.addAttribute("command", "Add Holiday");
        model.addAttribute("Holiday", new Holiday("Start Date...", "Last Date...", "Employee ID..."));

        return "holiday";
        }

    }


    @PostMapping("/save")
    public String save (Model model, Holiday holiday){
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }

    holidayRepository.save(holiday);
    model.addAttribute("command", holiday);
    return "redirect:/holidayView";

    }

    @GetMapping("/holidayView")
    public String holidayView(Model model){
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }
        List<Holiday> holidayList = holidayRepository.findAll();
        model.addAttribute("holidayList", holidayList);
        return "holidayView";
    }

    @GetMapping("/holidayEdit/{id}")
    public String holidayEdit(Model model, Holiday holiday, @PathVariable int id){
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
            return "redirect:/user/login";
        }
        Holiday holiday = holidayRepository.findById(id);
        model.addAttribute("command", "Edit holiday");
        model.addAttribute("action", "update");
        return "holidayUpdate";
    }

    @GetMapping ("/holidayUpdate")
    public String holidayUpdate(Model model, Holiday holiday){
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
                return "redirect:/user/login";
        holidayRepository.update(holiday);
        return "redirect:/holidayView";

    }

}
    @GetMapping("/holidayDelete/{id}")
    public String holidayDelete(Model model, @PathVariable int id){
        if(UserPrincipal.getInstance().getLoggedUser() == null) {
                return "redirect:/user/login";
        holidayRepository.delete(id);
        return "redirect:/holidayView";

        }
    }

}