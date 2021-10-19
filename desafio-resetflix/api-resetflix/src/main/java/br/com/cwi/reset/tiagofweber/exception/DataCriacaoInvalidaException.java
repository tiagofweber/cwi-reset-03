package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataCriacaoInvalidaException extends Exception {
    public DataCriacaoInvalidaException() {
        super("Não é possível cadastrar estúdios do futuro");
    }
}
