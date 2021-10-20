package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.model.*;
import br.com.cwi.reset.tiagofweber.request.FilmeRequest;

import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    PersonagemService personagemService = new PersonagemService(FakeDatabase.getInstance());
    DiretorService diretorService = new DiretorService(FakeDatabase.getInstance());
    EstudioService estudioService = new EstudioService(FakeDatabase.getInstance());

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaFilmes().size() + 1;

        personagemService.criarPersonagens(filmeRequest.getPersonagens());

        List<PersonagemAtor> personagens = fakeDatabase.recuperaPersonagens();

        Filme filme = new Filme(
                novoId,
                filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                estudioService.consultarEstudio(filmeRequest.getIdEstudio()),
                personagens,
                filmeRequest.getResumo()
        );

        fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes() {
        return fakeDatabase.recuperaFilmes();
    }
}
