package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioNaoInformadoException, NomeIncompletoException, DataNascimentoInvalidaException, AnoInicioAtividadeInvalidoException {

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

        fakeDatabase.persisteAtor(ator);
    }

    
}
