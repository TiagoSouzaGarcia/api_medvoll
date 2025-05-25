package med.voll.api_medvoll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloContoller {

    @GetMapping
    public String olaMundo() {
        System.out.println("Hello World!");
        return "Hello!";
    }
}
