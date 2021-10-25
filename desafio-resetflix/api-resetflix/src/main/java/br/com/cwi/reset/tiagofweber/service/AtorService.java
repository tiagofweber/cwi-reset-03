package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.StatusCarreira;
import br.com.cwi.reset.tiagofweber.repository.AtorRepository;
import br.com.cwi.reset.tiagofweber.request.AtorRequest;
import br.com.cwi.reset.tiagofweber.response.AtorEmAtividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        Ator atorJaExistente = atorRepository.findByNome(atorRequest.getNome());

        if (atorJaExistente != null) {
            throw new CadastroDuplicadoException("ator", atorJaExistente.getNome());
        }

        Ator ator = new Ator(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade()
        );

        atorRepository.save(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<Ator> atores = atorRepository.findAll();
        List<Ator> atoresEmAtividade = new ArrayList<>();
        List<AtorEmAtividade> atoresFiltrados = new ArrayList<>();

        if (atores.size() == 0) {
            throw new AtorNaoEncontradoException();
        }

        for (Ator ator: atores) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                atoresEmAtividade.add(ator);
            }
        }

        if (filtroNome.equals("")) {
            for (Ator ator: atoresEmAtividade) {
                atoresFiltrados.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
            }
        } else {
            for (Ator ator: atoresEmAtividade) {
                if (ator.getNome().contains(filtroNome)) {
                    atoresFiltrados.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        }

        if (atoresFiltrados.size() == 0) {
            throw new FiltroNomeNaoEncontradoException("ator", filtroNome);
        }

        return atoresFiltrados;
    }

    public Optional<Ator> consultarAtor(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformadoException();
        }

        Optional<Ator> ator = atorRepository.findById(id);

        if (ator == null) {
            throw new IdNaoEncontradoException("ator", id);
        }
        return ator;
    }

    public List<Ator> consultarAtores() throws Exception {
        List<Ator> atores = atorRepository.findAll();
        if (atores.size() == 0) {
            throw new AtorNaoEncontradoException();
        }
        return atores;
    }
}
