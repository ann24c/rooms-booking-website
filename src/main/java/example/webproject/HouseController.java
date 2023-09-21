package example.webproject;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/houses")
public class HouseController {
    @GetMapping
    public String showHouses(Model model){
        return "houses";
    }
}
