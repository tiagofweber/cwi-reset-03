package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataNascimentoInvalidaException extends Exception {
    public DataNascimentoInvalidaException(String tipo) {
        super(String.format("Não é possível cadastrar %s não nascidos", tipo));
    }
}
