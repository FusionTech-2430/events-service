package co.allconnected.fussiontech.eventsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {
    @GetMapping("/foo")
    public String fooBar() {
        return "Foo Bar";
    }
}
