package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioNaoInformadoException, NomeIncompletoException, DataNascimentoInvalidaException, AnoInicioAtividadeInvalidoException, NomeInvalidoException {

        Integer novoId = fakeDatabase.recuperaAtores().size() + 1;
        LocalDate dataAtual = LocalDate.now();

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
            throw new DataNascimentoInvalidaException();
        }

        if (ator.getAnoInicioAtividade() <= ator.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException();
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator atorCadastrado: atores) {
            if (atorCadastrado.getNome().equals(ator.getNome())) {
                throw new NomeInvalidoException(ator.getNome());
            }
        }

        fakeDatabase.persisteAtor(ator);
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
