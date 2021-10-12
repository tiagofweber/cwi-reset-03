package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoObrigatorioNaoInformadoException, NomeIncompletoException, DataNascimentoInvalidaException, AnoInicioAtividadeInvalidoException {

        Integer novoId = fakeDatabase.recuperaDiretores().size() + 1;

        Diretor diretor = new Diretor(novoId, diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        if (diretor.getNome() == null || diretor.getNome().equals("")) {
            throw new CampoObrigatorioNaoInformadoException("nome");
        } else if (diretor.getDataNascimento() == null) {
            throw new CampoObrigatorioNaoInformadoException("data de nascimento");
        } else if (diretor.getAnoInicioAtividade() == null) {
            throw new CampoObrigatorioNaoInformadoException("ano inicio atividade");
        }

        if (!diretor.getNome().contains(" ")) {
            throw new NomeIncompletoException();
        }

        if (diretor.getDataNascimento().isAfter(LocalDate.now())) {
            throw new DataNascimentoInvalidaException("diretores");
        }

        if (diretor.getAnoInicioAtividade() <= diretor.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException("diretor");
        }

        fakeDatabase.persisteDiretor(diretor);

    }
}
