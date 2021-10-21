package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.CadastroDuplicadoException;
import br.com.cwi.reset.tiagofweber.exception.FilmeNaoCadastradoException;
import br.com.cwi.reset.tiagofweber.exception.FilmeNaoEncontradoException;
import br.com.cwi.reset.tiagofweber.model.*;
import br.com.cwi.reset.tiagofweber.request.FilmeRequest;
import br.com.cwi.reset.tiagofweber.validator.Validacao;

import java.util.ArrayList;
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

        List<Filme> filmes = fakeDatabase.recuperaFilmes();

        for (Filme filme : filmes) {
            if (filme.getNome().equals(filmeRequest.getNome())) {
                throw new CadastroDuplicadoException("filme", filmeRequest.getNome());
            }
        }

        Validacao.validarPersonagens(filmeRequest.getPersonagens());
        List<PersonagemAtor> personagens = personagemService.criarPersonagens(filmeRequest.getPersonagens());

        Validacao.validarString(TipoDado.NOME, filmeRequest.getNome());
        Validacao.validarInteger(TipoDado.ANO_LANCAMENTO, filmeRequest.getAnoLancamento());
        Validacao.validarString(TipoDado.CAPA_FILME, filmeRequest.getCapaFilme());
        Validacao.validarGenero(filmeRequest.getGeneros());
        Validacao.validarInteger(TipoDado.ID_DIRETOR, filmeRequest.getIdDiretor());
        Validacao.validarInteger(TipoDado.ID_ESTUDIO, filmeRequest.getIdEstudio());
        Validacao.validarString(TipoDado.RESUMO, filmeRequest.getResumo());
        
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

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {

        List<Filme> filmes = fakeDatabase.recuperaFilmes();

        if (filmes.isEmpty()) {
            throw new FilmeNaoCadastradoException();
        }

        List<Filme> filmesFiltrados = new ArrayList<>();

        filmesFiltrados.addAll(filmes);

        if (!nomeFilme.equals("")) {
            filmesFiltrados.removeIf(filme1 -> !filme1.getNome().contains(nomeFilme));
        }

        if (!nomeDiretor.equals("")) {
            filmesFiltrados.removeIf(filme2 -> !filme2.getDiretor().getNome().contains(nomeDiretor));
        }

        if (!nomePersonagem.equals("")) {
            for (int i = 0; i < filmesFiltrados.size(); i++) {
                List<PersonagemAtor> personagens = filmesFiltrados.get(i).getPersonagens();
                boolean personagemEncontrado = false;
                for (PersonagemAtor personagem : personagens) {
                    if (personagem.getNomePersonagem().contains(nomePersonagem)) {
                        personagemEncontrado = true;
                    }
                }
                if (!personagemEncontrado) {
                    filmesFiltrados.remove(filmesFiltrados.get(i));
                }
            }
        }

        if (filmesFiltrados.isEmpty()) {
            throw new FilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return filmesFiltrados;
    }
}
