package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Estudio;
import br.com.cwi.reset.tiagofweber.repository.EstudioRepository;
import br.com.cwi.reset.tiagofweber.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        Estudio estudioJaExistente = estudioRepository.findByNome(estudioRequest.getNome());

        if (estudioJaExistente != null) {
            throw new CadastroDuplicadoException("estudio", estudioRequest.getNome());
        }

        Estudio estudio = new Estudio(
                estudioRequest.getNome(),
                estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade()
        );

        estudioRepository.save(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {

        List<Estudio> estudios = estudioRepository.findAll();
        List<Estudio> estudiosFiltrados = estudioRepository.findByNomeContaining(filtroNome);

        if (estudios.size() == 0) {
            throw new EstudioNaoCadastradoException();
        }

        if (filtroNome.equals("")) {
            return estudios;
        }

        if (estudiosFiltrados.size() == 0) {
            throw new FiltroNomeNaoEncontradoException("Estúdio", filtroNome);
        }

        return estudiosFiltrados;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformadoException();
        }

        Estudio estudio = estudioRepository.findByIdEquals(id);

        if (estudio == null) {
            throw new IdNaoEncontradoException("Estúdio", id);
        }

        return estudio;
    }


}
