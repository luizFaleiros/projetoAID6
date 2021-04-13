package br.com.projeto.controllers;

import br.com.projeto.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/sum/{num1}/{num2}")
    public ResponseEntity<Double> soma(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.sum(num1,num2));
    }

    @GetMapping("/subt/{num1}/{num2}")
    public ResponseEntity<Double> subt(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.sub(num1,num2));
    }

    @GetMapping("/mult/{num1}/{num2}")
    public ResponseEntity<Double> mult(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.multiple(num1,num2));
    }

    @GetMapping("/divide/{num1}/{num2}")
    public ResponseEntity<Double> divide(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.divide(num1,num2));
    }

    @GetMapping("/exp/{num1}/{num2}")
    public ResponseEntity<Double> exp(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.exp(num1,num2));
    }

}
