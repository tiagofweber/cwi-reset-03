package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneroVazioException extends Exception {
    public GeneroVazioException() {
        super("Deve ser informado pelo menos um gênero para o cadastro do filme");
    }
}
