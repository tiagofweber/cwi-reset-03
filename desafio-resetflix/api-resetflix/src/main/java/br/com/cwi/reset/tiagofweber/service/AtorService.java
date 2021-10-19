package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.StatusCarreira;
import br.com.cwi.reset.tiagofweber.request.AtorRequest;
import br.com.cwi.reset.tiagofweber.response.AtorEmAtividade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaAtores().size() + 1;

        Ator ator = new Ator(novoId, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        if (ator.getNome() == null || ator.getNome().equals("")) {
            throw new NomeNaoInformadoException();
        } else if (ator.getDataNascimento() == null) {
            throw new DataDeNascimentoNaoInformadaException();
        } else if (ator.getStatusCarreira() == null) {
            throw new CampoNaoInformadoException("status carreira");
        } else if (ator.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (ator.getNome().split(" ").length < 2) {
            throw new NomeSobrenomeObrigatorioException("ator");
        }

        if (ator.getDataNascimento().isAfter(LocalDate.now())) {
            throw new DataNascimentoInvalidaException("atores");
        }

        if (ator.getAnoInicioAtividade() <= ator.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException("ator");
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator atorCadastrado: atores) {
            if (atorCadastrado.getNome().equals(ator.getNome())) {
                throw new CadastroDuplicadoException("ator", atorCadastrado.getNome());
            }
        }

        fakeDatabase.persisteAtor(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<Ator> atores = fakeDatabase.recuperaAtores();
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

    public Ator consultarAtor(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformadoException();
        }
        List<Ator> atores = fakeDatabase.recuperaAtores();
        Ator atorEncontrado = null;
        for (Ator ator: atores) {
            if (ator.getId().equals(id)) {
                atorEncontrado = ator;
            }
        }
        if (atorEncontrado == null) {
            throw new IdNaoEncontradoException("ator", id);
        }
        return atorEncontrado;
    }

    public List<Ator> consultarAtores() throws Exception {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        if (atores.size() == 0) {
            throw new AtorNaoEncontradoException();
        }
        return atores;
    }
}
