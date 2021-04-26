package br.com.projeto.services;

import br.com.projeto.util.NumericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Double sum(Double double1, Double double2) {
        return double1 + double2;
    }

    public Double divide(Double double1, Double double2) {
        return double1 / double2;
    }

    public Double multiple(Double double1, Double double2) {
        return double1 * double2;
    }

    public Double sub(Double double1, Double double2) {
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
