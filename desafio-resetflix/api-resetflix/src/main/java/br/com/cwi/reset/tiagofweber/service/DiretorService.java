package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Diretor;
import br.com.cwi.reset.tiagofweber.request.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    /*public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        Integer novoId = fakeDatabase.recuperaDiretores().size() + 1;

        Diretor diretor = new Diretor(novoId, diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        if (diretor.getNome() == null || diretor.getNome().equals("")) {
            throw new NomeNaoInformadoException();
        } else if (diretor.getDataNascimento() == null) {
            throw new DataDeNascimentoNaoInformadaException();
        } else if (diretor.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (diretor.getNome().split(" ").length < 2) {
            throw new NomeSobrenomeObrigatorioException("diretor");
        }

        if (diretor.getDataNascimento().isAfter(LocalDate.now())) {
            throw new DataNascimentoInvalidaException("diretores");
        }

        if (diretor.getAnoInicioAtividade() <= diretor.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException("diretor");
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretorCadastrado: diretores) {
            if (diretorCadastrado.getNome().equals(diretor.getNome())) {
                throw new CadastroDuplicadoException("diretor", diretor.getNome());
            }
        }

        fakeDatabase.persisteDiretor(diretor);

    }*/

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        List<Diretor> diretoresFiltrados = new ArrayList<>();

        if (diretores.size() == 0) {
            throw new DiretorNaoEncontradoException();
        }

        for (Diretor diretor: diretores) {
            if (filtroNome.equals("")) {
                diretoresFiltrados.add(diretor);
            } else {
                if (diretor.getNome().contains(filtroNome)) {
                    diretoresFiltrados.add(diretor);
                }
            }
        }

        if (diretoresFiltrados.size() == 0) {
            throw new FiltroNomeNaoEncontradoException("diretor", filtroNome);
        }

        return diretoresFiltrados;
    }

    public Diretor consultarDiretor(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformadoException();
        }
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        Diretor diretorEncontrado = null;
        for (Diretor diretor: diretores) {
            if (diretor.getId().equals(id)) {
                diretorEncontrado = diretor;
            }
        }
        if (diretorEncontrado == null) {
            throw new IdNaoEncontradoException("diretor", id);
        }
        return diretorEncontrado;
    }
}
