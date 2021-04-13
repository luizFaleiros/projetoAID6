package br.com.projeto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotANumberException extends RuntimeException implements Serializable {

    public NotANumberException(String message) {
        super(message);
    }
}
