package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroNomeNaoEncontradoException extends Exception {
    public FiltroNomeNaoEncontradoException(String tipo, String filtroNome) {
        super(String.format("%s não encontrado com o filtro %s, favor informar outro filtro", tipo, filtroNome));
    }
}
