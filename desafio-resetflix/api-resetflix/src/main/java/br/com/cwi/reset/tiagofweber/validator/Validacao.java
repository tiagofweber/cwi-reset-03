package br.com.cwi.reset.tiagofweber.validator;

import br.com.cwi.reset.tiagofweber.exception.AtorPersonagemDuplicadoException;
import br.com.cwi.reset.tiagofweber.exception.CampoNaoInformadoException;
import br.com.cwi.reset.tiagofweber.exception.GeneroDuplicadoException;
import br.com.cwi.reset.tiagofweber.exception.GeneroVazioException;
import br.com.cwi.reset.tiagofweber.model.Genero;
import br.com.cwi.reset.tiagofweber.model.TipoDado;
import br.com.cwi.reset.tiagofweber.request.PersonagemRequest;

import java.util.List;

public class Validacao {

    public static void validarString(TipoDado tipoDado, String value) throws Exception {
        if (value == null || value.isEmpty()) {
            throw new CampoNaoInformadoException(tipoDado.getDescricao());
        }
    }

    public static void validarInteger(TipoDado tipoDado, Integer num) throws Exception {
        if (num == null) {
            throw new CampoNaoInformadoException(tipoDado.getDescricao());
        }
    }

    public static void validarGenero(List<Genero> generos) throws Exception {
        if (generos == null) {
            throw new CampoNaoInformadoException(TipoDado.GENERO.getDescricao());
        }
        if (generos.isEmpty()) {
            throw new GeneroVazioException();
        }
        int contador = 0;
        for (int i = 0; i < generos.size(); i++) {
            for (int j = 0; j < generos.size(); j++) {
                if (generos.get(i) == generos.get(j)) {
                    contador++;
                }
            }
            if (contador > 1) {
                throw new GeneroDuplicadoException();
            }
            contador = 0;
        }
    }

    public static void validarPersonagens(List<PersonagemRequest> personagens) throws Exception {
        if (personagens == null || personagens.isEmpty()) {
            throw new CampoNaoInformadoException(TipoDado.PERSONAGENS.getDescricao());
        }
        int contador = 0;
        for (int i = 0; i < personagens.size(); i++) {
            for (int j = 0; j < personagens.size(); j++) {
                if (personagens.get(i).getIdAtor() == personagens.get(j).getIdAtor()) {
                    if (personagens.get(i).getNomePersonagem().equals(personagens.get(j).getNomePersonagem())) {
                        contador++;
                    }
                }
            }
            if (contador > 1) {
                throw new AtorPersonagemDuplicadoException();
            }
            contador = 0;
        }
    }
}
