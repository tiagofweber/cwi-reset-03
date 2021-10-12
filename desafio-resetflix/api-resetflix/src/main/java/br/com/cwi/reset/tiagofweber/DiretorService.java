package br.com.cwi.reset.tiagofweber;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoObrigatorioNaoInformadoException, NomeIncompletoException {

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

        fakeDatabase.persisteDiretor(diretor);

    }
}
