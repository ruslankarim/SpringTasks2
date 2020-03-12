package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;

@Controller
@RequestMapping("/")
public class CarsController {

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printCars(ModelMap model, @RequestParam (required = false) String locale){
        System.out.println(locale);
        model.addAttribute("cars", CarService.getCars());
        model.addAttribute("locale", locale);
        return "cars";
    }
}
