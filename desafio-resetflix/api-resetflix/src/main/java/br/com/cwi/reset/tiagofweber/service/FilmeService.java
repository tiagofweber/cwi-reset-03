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

    PersonagemService personagemService = new PersonagemService(fakeDatabase);

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaFilmes().size() + 1;
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        Diretor diretorEncontrado = null;
        Estudio estudioEncontrado = null;

        for (Diretor diretor : diretores) {
            if (diretor.getId() == filmeRequest.getIdDiretor()) {
                diretorEncontrado = diretor;
            }
        }

        for (Estudio estudio: estudios) {
            if (estudio.getId() == filmeRequest.getIdEstudio()) {
                estudioEncontrado = estudio;
            }
        }

        personagemService.criarPersonagens(filmeRequest.getPersonagens());

        List<PersonagemAtor> personagens = fakeDatabase.recuperaPersonagens();

        Filme filme = new Filme(
                novoId,
                filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                diretorEncontrado,
                estudioEncontrado,
                personagens,
                filmeRequest.getResumo()
        );

        fakeDatabase.persisteFilme(filme);
    }
}
