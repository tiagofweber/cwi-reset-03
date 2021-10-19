package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNaoEncontradoException extends Exception {
    public IdNaoEncontradoException(String tipo, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro id=%o, favor verifique os parâmetros informados", tipo, id));
    }
}
