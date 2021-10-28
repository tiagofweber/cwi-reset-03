package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.*;
import br.com.cwi.reset.tiagofweber.repository.FilmeRepository;
import br.com.cwi.reset.tiagofweber.request.FilmeRequest;
import br.com.cwi.reset.tiagofweber.validator.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private DiretorService diretorService;
    @Autowired
    private EstudioService estudioService;
    @Autowired
    private PersonagemService personagemService;

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {
        Filme filmeJaExistente = filmeRepository.findByNome(filmeRequest.getNome());

        if (filmeJaExistente != null) {
            throw new CadastroDuplicadoException("filme", filmeRequest.getNome());
        }

        Validacao.validarGeneros(filmeRequest.getGeneros());
        Validacao.validarPersonagens(filmeRequest.getPersonagens());
        List<PersonagemAtor> personagens = personagemService.criarPersonagens(filmeRequest.getPersonagens());

        Filme filme = new Filme(
                filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                estudioService.consultarEstudio(filmeRequest.getIdEstudio()),
                diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                personagens,
                filmeRequest.getResumo()
        );

        filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes(
            String nomeFilme,
            String nomeDiretor,
            String nomePersonagem,
            String nomeAtor
    ) throws Exception {

        List<Filme> filmes = filmeRepository.findAll();

        if (filmes.isEmpty()) {
            throw new FilmeNaoCadastradoException();
        }

        if (nomeFilme.equals("") && nomeDiretor.equals("") && nomePersonagem.equals("") && nomeAtor.equals("")) {
            return filmes;
        }

        List<Filme> filmesFiltrados = new ArrayList<>();
        if (!nomeFilme.equals("")) {
            List<Filme> filmesFiltradosPorNome = filmeRepository.findByNomeContainingIgnoreCase(nomeFilme);
            filmesFiltrados.addAll(filmesFiltradosPorNome);
        }

        if (!nomeDiretor.equals("")) {
            List<Filme> filmesFiltradosPorDiretor = filmeRepository.findByDiretorNomeContainingIgnoreCase(nomeDiretor);
            filmesFiltrados.addAll(filmesFiltradosPorDiretor);
        }

        if (!nomePersonagem.equals("")) {
            List<Filme> filmesFiltradosPorPersonagem = filmeRepository.findByPersonagensNomePersonagemContainingIgnoreCase(nomePersonagem);
            filmesFiltrados.addAll(filmesFiltradosPorPersonagem);
        }

        if (!nomeAtor.equals("")) {
            List<Filme> filmesFiltradosPorAtor = filmeRepository.findByPersonagensAtorNomeContainingIgnoreCase(nomeAtor);
            filmesFiltrados.addAll(filmesFiltradosPorAtor);
        }

        List<Filme> filmesFiltradosSemDuplicatas = new ArrayList<>(new HashSet<>(filmesFiltrados));

        if (filmesFiltradosSemDuplicatas.isEmpty()) {
            throw new FilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return filmesFiltradosSemDuplicatas;
    }

    public void removerFilme(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformadoException();
        }

        if (!filmeRepository.existsById(id)) {
            throw new IdNaoEncontradoException("filme", id);
        }

        Filme filme = filmeRepository.findById(id).get();

        List<PersonagemAtor> personagens = filme.getPersonagens();

        for (PersonagemAtor personagem : personagens) {
            personagemService.removerPersonagem(personagem);
        }

        filmeRepository.delete(filme);
    }
}
