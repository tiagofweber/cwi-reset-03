package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.model.*;
import br.com.cwi.reset.tiagofweber.request.FilmeRequest;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    private DiretorService diretorService = new DiretorService(fakeDatabase);
    private EstudioService estudioService = new EstudioService(fakeDatabase);

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaFilmes().size() + 1;
        Diretor diretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());
        Estudio estudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());

        List<PersonagemAtor> personagens = new ArrayList<>();
        personagens.add(new PersonagemAtor(
                1,
                fakeDatabase.recuperaAtores().get(0),
                "Jerry",
                "Rato que vive sendo perseguido pelo gato Tom",
                TipoAtuacao.PRINCIPAL
        ));
        personagens.add(new PersonagemAtor(
                2,
                fakeDatabase.recuperaAtores().get(1),
                "Tom",
                "Gato que contracena com o rato Jerry",
                TipoAtuacao.COADJUVANTE
        ));

        Filme filme = new Filme(
                novoId,
                filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                diretor,
                estudio,
                personagens,
                filmeRequest.getResumo()
        );

        fakeDatabase.persisteFilme(filme);
    }
}
