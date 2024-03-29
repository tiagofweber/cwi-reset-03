package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstudioNaoCadastradoException extends Exception {
    public EstudioNaoCadastradoException() {
        super("Nenhum estúdio cadastrado, favor cadastrar estúdios");
    }
}
