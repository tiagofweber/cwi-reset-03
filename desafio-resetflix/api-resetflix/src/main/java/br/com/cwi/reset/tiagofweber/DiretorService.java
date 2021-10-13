package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoObrigatorioNaoInformadoException, NomeIncompletoException, DataInvalidaException, NomeInvalidoException {

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
            throw new DataInvalidaException("Não é possível cadastrar diretores não nascidos");
        }

        if (diretor.getAnoInicioAtividade() <= diretor.getDataNascimento().getYear()) {
            throw new DataInvalidaException("Ano de início de atividade inválido para o diretor cadastrado");
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretorCadastrado: diretores) {
            if (diretorCadastrado.getNome().equals(diretor.getNome())) {
                throw new NomeInvalidoException("diretor", diretor.getNome());
            }
        }

        fakeDatabase.persisteDiretor(diretor);

    }

    public List<Diretor> listarDiretores(String filtroNome) throws DiretorNaoCadastradoException {
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        List<Diretor> diretoresFiltrados = new ArrayList<>();

        if (diretores.size() == 0) {
            throw new DiretorNaoCadastradoException("Nenhum diretor cadastrado, favor cadastrar diretores.");
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
            throw new DiretorNaoCadastradoException(String.format("Diretor não encontrado com filtro %s, favor informar outro filtro", filtroNome));
        }

        return diretoresFiltrados;
    }

    public Diretor consultarDiretor(Integer id) throws CampoObrigatorioNaoInformadoException, DiretorNaoCadastradoException {
        if (id == null) {
            throw new CampoObrigatorioNaoInformadoException("id");
        }
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        Diretor diretorEncontrado = null;
        for (Diretor diretor: diretores) {
            if (diretor.getId().equals(id)) {
                diretorEncontrado = diretor;
            }
        }
        if (diretorEncontrado == null) {
            throw new DiretorNaoCadastradoException("Nenhum diretor encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
        }
        return diretorEncontrado;
    }
}
