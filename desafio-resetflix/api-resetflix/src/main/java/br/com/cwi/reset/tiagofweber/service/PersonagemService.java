package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;
import br.com.cwi.reset.tiagofweber.request.PersonagemRequest;

import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarPersonagem(PersonagemRequest personagemRequest) {

        Integer novoId = fakeDatabase.recuperaPersonagens().size() + 1;
        List<Ator> atores = fakeDatabase.recuperaAtores();
        Ator atorEncontrado = null;

        for (Ator ator : atores) {
            if (ator.getId().equals(personagemRequest.getIdAtor())) {
                atorEncontrado = ator;
            }
        }

        PersonagemAtor personagemAtor = new PersonagemAtor(
                novoId,
                atorEncontrado,
                personagemRequest.getNomePersonagem(),
                personagemRequest.getDescricaoPersonagem(),
                personagemRequest.getTipoAtuacao()
        );

        fakeDatabase.persistePersonagem(personagemAtor);
    }

}
