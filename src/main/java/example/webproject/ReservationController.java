package example.webproject;

import example.webproject.Entities.Guest;
import example.webproject.Entities.Reservation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @GetMapping
    public String showReservationForm(Model model){
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping
    public String processReservation(Reservation reservation){
        return "home";
    }
}
