package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilmeNaoCadastradoException extends Exception {
    public FilmeNaoCadastradoException() {
        super("Nenhum filme cadastrado, favor cadastrar filmes");
    }
}
