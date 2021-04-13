package br.com.projeto.services;

import br.com.projeto.util.NumericUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final NumericUtil numericUtil;

    public Double sum(String num1, String num2){
       Double double1 = numericUtil.convertToDouble(num1);
        Double double2 = numericUtil.convertToDouble(num2);
        return double1 + double2;
    }

    public Double divide(String num1, String num2){
        Double double1 = numericUtil.convertToDouble(num1);
        Double double2 = numericUtil.convertToDouble(num2);
        return double1 / double2;
    }

    public Double multiple(String num1, String num2){
        Double double1 = numericUtil.convertToDouble(num1);
        Double double2 = numericUtil.convertToDouble(num2);
        return double1 * double2;
    }

    public Double sub(String num1, String num2){
        Double double1 = numericUtil.convertToDouble(num1);
        Double double2 = numericUtil.convertToDouble(num2);
        return double1 - double2;
    }

    public Double exp(String num1, String num2){
        Double double1 = numericUtil.convertToDouble(num1);
        Double res = double1;
        Integer inteiro = Integer.parseInt(num2);
        for (int i = 0; i < inteiro; i++){
            res += res * double1;
        }
        return res;
    }

}
