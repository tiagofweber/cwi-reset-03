package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorNaoEncontradoException extends Exception {
    public DiretorNaoEncontradoException() {
        super("Nenhum diretor cadastrado, favor cadastrar diretores");
    }
}
