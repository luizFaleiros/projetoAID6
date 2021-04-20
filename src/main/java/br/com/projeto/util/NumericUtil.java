package br.com.projeto.util;

import br.com.projeto.exception.NotANumberException;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NumericUtil {

    public Double convertToDouble(String num) {
        if (Objects.isNull(num)) {
            throw new NotANumberException("Numero não digitado");
        }
        var number = num.replace(",",".");
        isNumeric(num);
        return Double.parseDouble(number);

    }

    public void isNumeric(String strNumber){
        if(Objects.isNull(strNumber)){
            throw new NotANumberException("Não existe o numero");
        }

        if(BooleanUtils.isFalse(strNumber.matches("[-+]?[0-9]*\\.?[0-9]+"))){
            throw new NotANumberException("Não é um numero");
        }
    }

}
