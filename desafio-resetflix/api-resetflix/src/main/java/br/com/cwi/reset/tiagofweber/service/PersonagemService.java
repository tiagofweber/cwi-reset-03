package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.AtorNaoEncontradoException;
import br.com.cwi.reset.tiagofweber.exception.IdNaoEncontradoException;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;
import br.com.cwi.reset.tiagofweber.request.PersonagemRequest;

import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    public void criarPersonagens(List<PersonagemRequest> personagensRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaPersonagens().size() + 1;

        for (PersonagemRequest personagemRequest : personagensRequest) {

            Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());

            if (ator == null) {
                throw new IdNaoEncontradoException("ator", personagemRequest.getIdAtor());
            }

            PersonagemAtor personagemAtor = new PersonagemAtor(
                    novoId,
                    ator,
                    personagemRequest.getNomePersonagem(),
                    personagemRequest.getDescricaoPersonagem(),
                    personagemRequest.getTipoAtuacao()
            );

            fakeDatabase.persistePersonagem(personagemAtor);
        }


    }

}
