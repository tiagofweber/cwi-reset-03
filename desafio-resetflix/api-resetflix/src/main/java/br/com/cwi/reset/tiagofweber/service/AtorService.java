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

        if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException("ator");
        }

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

        List<AtorEmAtividade> atores = atorRepository.findByNomeContainingIgnoreCaseAndStatusCarreiraEquals(filtroNome, StatusCarreira.EM_ATIVIDADE);

        if (atores == null) {
            throw new AtorNaoEncontradoException();
        }
        if (atores.size() == 0) {
            throw new FiltroNomeNaoEncontradoException("ator", filtroNome);
        }

        return atores;
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
