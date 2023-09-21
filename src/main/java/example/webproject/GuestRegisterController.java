package example.webproject;

import example.webproject.Entities.Guest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/register")
public class GuestRegisterController {
    @GetMapping
    public String showRegisterForm(Model model){
        model.addAttribute("guest", new Guest());
        return "register";
    }

    @PostMapping
    public String processRegistration(Guest guest){
        log.info(guest.toString());
        return "home";
    }
}
