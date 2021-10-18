package br.com.cwi.reset.tiagofweber;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoInvalidoException extends Exception {
    public CampoInvalidoException(String message) {
        super(message);
    }
}
