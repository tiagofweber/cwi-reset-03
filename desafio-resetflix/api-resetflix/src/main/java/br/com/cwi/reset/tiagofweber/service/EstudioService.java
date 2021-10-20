package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Estudio;
import br.com.cwi.reset.tiagofweber.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaEstudios().size() + 1;

        if (estudioRequest.getNome() == null || estudioRequest.getNome().equals("")) {
            throw new NomeNaoInformadoException();
        }
        if (estudioRequest.getDescricao() == null || estudioRequest.getDescricao().equals("")) {
            throw new DescricaoNaoInformadaException();
        }
        if (estudioRequest.getDataCriacao() == null) {
            throw new DataCriacaoNaoInformadaException();
        }
        if (estudioRequest.getStatusAtividade() == null) {
            throw new CampoNaoInformadoException("status de atividade");
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : estudios) {
            if (estudio.getNome().equals(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException("estudio", estudioRequest.getNome());
            }
        }

        if (estudioRequest.getDataCriacao().isAfter(LocalDate.now())) {
            throw new DataCriacaoInvalidaException();
        }

        Estudio estudio = new Estudio(novoId, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        List<Estudio> estudiosFiltrados = new ArrayList<>();

        if (!filtroNome.equals("")) {
            for (Estudio estudio : estudios) {
                if (estudio.getNome().contains(filtroNome)) {
                    estudiosFiltrados.add(estudio);
                }
            }
            if (estudiosFiltrados.size() == 0) {
                throw new FiltroNomeNaoEncontradoException("Estúdio", filtroNome);
            }
            return estudiosFiltrados;
        }

        if (estudios.size() == 0) {
            throw new EstudioNaoCadastradoException();
        }

        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (id == null) {
            throw new IdNaoInformadoException();
        }

        for (Estudio estudio : estudios) {
            if (estudio.getId() == id) {
                return estudio;
            }
        }

        throw new IdNaoEncontradoException("Estúdio", id);
    }


}
