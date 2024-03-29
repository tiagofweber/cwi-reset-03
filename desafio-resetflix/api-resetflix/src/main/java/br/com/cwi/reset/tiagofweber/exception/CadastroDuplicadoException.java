package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroDuplicadoException extends Exception {
    public CadastroDuplicadoException(String tipo, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome %s", tipo, nome));
    }
}
