package br.com.cwi.reset.tiagofweber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilmeNaoEncontradoException extends Exception {
    public FilmeNaoEncontradoException(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) {
        super(String.format("Filme não encontrado com os filtros nomeFilme=%s, nomeDiretor=%s, nomePersonagem=%s, " +
                "nomeAtor=%s, favor informar outros filtros", nomeFilme, nomeDiretor, nomePersonagem, nomeAtor));
    }
}
