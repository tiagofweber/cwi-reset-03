package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.exception.IdNaoEncontradoException;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;
import br.com.cwi.reset.tiagofweber.repository.PersonagemAtorRepository;
import br.com.cwi.reset.tiagofweber.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;
    @Autowired
    private AtorService atorService;

    public List<PersonagemAtor> criarPersonagens(List<PersonagemRequest> personagensRequest) throws Exception {

        List<PersonagemAtor> personagens = new ArrayList<>();

        for (PersonagemRequest personagemRequest : personagensRequest) {

            Optional<Ator> ator = atorService.consultarAtor(personagemRequest.getIdAtor());

            if (ator == null) {
                throw new IdNaoEncontradoException("ator", personagemRequest.getIdAtor());
            }

            PersonagemAtor personagemAtor = new PersonagemAtor(
                    ator,
                    personagemRequest.getNomePersonagem(),
                    personagemRequest.getDescricaoPersonagem(),
                    personagemRequest.getTipoAtuacao()
            );

            personagemAtorRepository.save(personagemAtor);
            personagens.add(personagemAtor);
        }
        return personagens;
    }

}
