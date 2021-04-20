package br.com.projeto.controllers;

import br.com.projeto.services.CalculatorService;
import br.com.projeto.util.NumericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    private final NumericUtil numericUtil;

    @GetMapping("/sum/{num1}/{num2}")
    public ResponseEntity<Double> soma(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.sum(numericUtil.convertToDouble(num1),numericUtil.convertToDouble(num2)));
    }

    @GetMapping("/subt/{num1}/{num2}")
    public ResponseEntity<Double> subt(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.sub(numericUtil.convertToDouble(num1),numericUtil.convertToDouble(num2)));
    }

    @GetMapping("/mult/{num1}/{num2}")
    public ResponseEntity<Double> mult(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.multiple(numericUtil.convertToDouble(num1),numericUtil.convertToDouble(num2)));
    }

    @GetMapping("/divide/{num1}/{num2}")
    public ResponseEntity<Double> divide(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.divide(numericUtil.convertToDouble(num1),numericUtil.convertToDouble(num2)));
    }

    @GetMapping("/exp/{num1}/{num2}")
    public ResponseEntity<Double> exp(@PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        return ResponseEntity.ok(calculatorService.exp(numericUtil.convertToDouble(num1),numericUtil.convertToInteger(num2)));
    }

    @GetMapping("/sqr/{num1}")
    public ResponseEntity<Double> exp(@PathVariable("num1") String num1) {

        return ResponseEntity.ok(calculatorService.sqr(numericUtil.convertToDouble(num1)));
    }


}
