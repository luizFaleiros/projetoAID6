package br.com.projeto.util;

import br.com.projeto.exception.NotANumberException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NumericUtil {

    public Double convertToDouble(String num) {
        if (Objects.isNull(num)) {
            throw new NotANumberException("Numero não digitado");
        }
        var number = num.replace(",",".");
        return Double.parseDouble(number);
    }
}
