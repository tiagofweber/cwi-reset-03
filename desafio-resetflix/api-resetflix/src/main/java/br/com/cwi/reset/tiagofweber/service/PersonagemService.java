package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.IdNaoEncontradoException;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;
import br.com.cwi.reset.tiagofweber.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    public List<PersonagemAtor> criarPersonagens(List<PersonagemRequest> personagensRequest) throws Exception {

        List<PersonagemAtor> personagens = new ArrayList<>();

        for (PersonagemRequest personagemRequest : personagensRequest) {

            Integer novoId = fakeDatabase.recuperaPersonagens().size() + 1;
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

            this.fakeDatabase.persistePersonagem(personagemAtor);
            personagens.add(personagemAtor);
        }
        return personagens;
    }

}
