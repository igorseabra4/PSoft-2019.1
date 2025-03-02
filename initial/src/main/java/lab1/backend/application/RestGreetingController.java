package lab1.backend.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lab1.backend.other.*;

@RestController
public class RestGreetingController {

    @RequestMapping("/greeting_json")
    public Greeting greeting(@RequestParam(name="name", defaultValue="World") String name) {
        return new Greeting(name, Common.getCumprimento());
    }
    
    @RequestMapping("/time_json")
    public ServerTime time() {
    	return new ServerTime(Common.getServerTime());
    }
}