package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataCriacaoNaoInformadaException extends CampoNaoInformadoException {
    public DataCriacaoNaoInformadaException() {
        super("data de criação");
    }
}
