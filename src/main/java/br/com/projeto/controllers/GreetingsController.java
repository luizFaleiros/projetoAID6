package br.com.projeto.controllers;

import br.com.projeto.domain.dto.GreetingsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    private static final String template = "Hello, %s";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public GreetingsDTO greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        return new GreetingsDTO(counter.incrementAndGet(), String.format(template,name));
    }
}
