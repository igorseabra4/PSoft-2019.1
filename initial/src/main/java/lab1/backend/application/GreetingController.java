package lab1.backend.application;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lab1.backend.other.Common;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("cumprimento", Common.getCumprimento());
    	
        return "greeting";
    }
    
    @GetMapping("/time")
    public String time(Model model) {
    	Calendar c = Calendar.getInstance();
    	String time = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND); 
    	model.addAttribute("hora_local", time);
    	
        return "time";
    }

}