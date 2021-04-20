package br.com.projeto.services;

import br.com.projeto.util.NumericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Double sum(Double num1, Double num2) {
        return double1 + double2;
    }

    public Double divide(Double num1, Double num2) {
        return double1 / double2;
    }

    public Double multiple(Double num1, Double num2) {
        return double1 * double2;
    }

    public Double sub(Double num1, Double num2) {
        return double1 - double2;
    }

    public Double exp(Double num1, Integer num2) {
        Double res = 1D;
        for (int i = 0; i < num2; i++) {
            res += res * num1;
        }
        return res;
    }

    public Double sqr(Double convertToDouble) {
        return convertToDouble*convertToDouble;
    }
}
