package br.com.cwi.reset.tiagofweber;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioNaoInformadoException {

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

        fakeDatabase.persisteAtor(ator);
    }
}
