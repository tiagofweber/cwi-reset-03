package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioNaoInformadoException, NomeIncompletoException, DataInvalidaException, NomeInvalidoException {

        Integer novoId = fakeDatabase.recuperaAtores().size() + 1;

        Ator ator = new Ator(novoId, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        if (ator.getNome() == null || ator.getNome().equals("")) {
            throw new CampoObrigatorioNaoInformadoException("nome");
        } else if (ator.getDataNascimento() == null) {
            throw new CampoObrigatorioNaoInformadoException("data de nascimento");
        } else if (ator.getStatusCarreira() == null) {
            throw new CampoObrigatorioNaoInformadoException("status carreira");
        } else if (ator.getAnoInicioAtividade() == null) {
            throw new CampoObrigatorioNaoInformadoException("ano inicio atividade");
        }

        if (!ator.getNome().contains(" ")) {
            throw new NomeIncompletoException();
        }

        if (ator.getDataNascimento().isAfter(LocalDate.now())) {
            throw new DataInvalidaException("Não é possível cadastrar atores não nascidos");
        }

        if (ator.getAnoInicioAtividade() <= ator.getDataNascimento().getYear()) {
            throw new DataInvalidaException("Ano de início de atividade inválido para o ator cadastrado");
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator atorCadastrado: atores) {
            if (atorCadastrado.getNome().equals(ator.getNome())) {
                throw new NomeInvalidoException("ator", ator.getNome());
            }
        }

        fakeDatabase.persisteAtor(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws AtorNaoCadastradoException {

        List<Ator> atores = fakeDatabase.recuperaAtores();
        List<Ator> atoresEmAtividade = new ArrayList<>();
        List<Ator> atoresFiltrados = new ArrayList<>();

        if (atores.size() == 0) {
            throw new AtorNaoCadastradoException("Nenhum ator cadastrado, favor cadastrar atores.");
        }

        for (Ator ator: atores) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                atoresEmAtividade.add(ator);
            }
        }

        if (filtroNome.equals("")) {
            for (Ator ator: atoresEmAtividade) {
                atoresFiltrados.add(ator);
            }
        } else {
            for (Ator ator: atoresEmAtividade) {
                if (ator.getNome().contains(filtroNome)) {
                    atoresFiltrados.add(ator);
                }
            }
        }

        if (atoresFiltrados.size() == 0) {
            throw new AtorNaoCadastradoException(String.format("Ator não encontrado com o filtro %s, favor informar outro filtro.", filtroNome));
        }

        return atoresFiltrados;
    }

    public Ator consultarAtor(Integer id) throws CampoObrigatorioNaoInformadoException, AtorNaoCadastradoException {
        if (id == null) {
            throw new CampoObrigatorioNaoInformadoException("id");
        }
        List<Ator> atores = fakeDatabase.recuperaAtores();
        Ator atorEncontrado = null;
        for (Ator ator: atores) {
            if (ator.getId().equals(id)) {
                atorEncontrado = ator;
            }
        }
        if (atorEncontrado == null) {
            throw new AtorNaoCadastradoException("Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
        }
        return atorEncontrado;
    }

    public List<Ator> consultarAtores() throws AtorNaoCadastradoException {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        if (atores.size() == 0) {
            throw new AtorNaoCadastradoException("Nenhum ator cadastrado, favor cadastrar atores.");
        }
        return atores;
    }
}
