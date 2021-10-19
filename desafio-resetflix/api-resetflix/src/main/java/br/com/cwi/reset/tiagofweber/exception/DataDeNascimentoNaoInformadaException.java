package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataDeNascimentoNaoInformadaException extends CampoNaoInformadoException {
    public DataDeNascimentoNaoInformadaException() {
        super("data de nascimento");
    }
}
