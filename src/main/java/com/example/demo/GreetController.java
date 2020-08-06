package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetController {
    private static final String template = "Hello, %s!";
    private AtomicLong id=new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "user",defaultValue = "world") String user){
        Greeting greeting=new Greeting();
        greeting.setId(id.incrementAndGet());
        greeting.setUser(String.format(template,user));
        return greeting;
    }
    @GetMapping("/")
    public Greeting index(){
        Greeting greeting=new Greeting();
        greeting.setId(id.incrementAndGet());
        greeting.setUser(String.format(template,"xlzhao"));
        return greeting;
    }
}
