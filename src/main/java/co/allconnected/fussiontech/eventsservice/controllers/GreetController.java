package co.allconnected.fussiontech.eventsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @GetMapping("/")
    public String index() {
        return "Hello world!";
    }
}
