package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.CadastroInvalidoException;
import br.com.cwi.reset.tiagofweber.exception.CampoInvalidoException;
import br.com.cwi.reset.tiagofweber.exception.DataInvalidaException;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.StatusCarreira;
import br.com.cwi.reset.tiagofweber.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws CampoInvalidoException, DataInvalidaException {

        Integer novoId = fakeDatabase.recuperaAtores().size() + 1;

        Ator ator = new Ator(novoId, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        if (ator.getNome() == null || ator.getNome().equals("")) {
            throw new CampoInvalidoException("Campo obrigatório não informado. Favor informar o campo nome");
        } else if (ator.getDataNascimento() == null) {
            throw new CampoInvalidoException("Campo obrigatório não informado. Favor informar o campo data de nascimento");
        } else if (ator.getStatusCarreira() == null) {
            throw new CampoInvalidoException("Campo obrigatório não informado. Favor informar o campo status carreira");
        } else if (ator.getAnoInicioAtividade() == null) {
            throw new CampoInvalidoException("Campo obrigatório não informado. Favor informar o campo ano inicio atividade");
        }

        if (!ator.getNome().contains(" ")) {
            throw new CampoInvalidoException("Deve ser informado no mínimo nome e sobrenome para o ator");
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
                throw new CampoInvalidoException(String.format("Já existe um ator cadastrado para o nome %s", ator.getNome()));
            }
        }

        fakeDatabase.persisteAtor(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws CadastroInvalidoException {

        List<Ator> atores = fakeDatabase.recuperaAtores();
        List<Ator> atoresEmAtividade = new ArrayList<>();
        List<Ator> atoresFiltrados = new ArrayList<>();

        if (atores.size() == 0) {
            throw new CadastroInvalidoException("Nenhum ator cadastrado, favor cadastrar atores");
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
            throw new CadastroInvalidoException(String.format("Ator não encontrado com o filtro %s, favor informar outro filtro", filtroNome));
        }

        return atoresFiltrados;
    }

    public Ator consultarAtor(Integer id) throws CampoInvalidoException, CadastroInvalidoException {
        if (id == null) {
            throw new CampoInvalidoException("Campo obrigatório não informado. Favor informar o campo id");
        }
        List<Ator> atores = fakeDatabase.recuperaAtores();
        Ator atorEncontrado = null;
        for (Ator ator: atores) {
            if (ator.getId().equals(id)) {
                atorEncontrado = ator;
            }
        }
        if (atorEncontrado == null) {
            throw new CadastroInvalidoException(String.format("Nenhum ator encontrado com o parâmetro id=%s, favor verifique os parâmetros informados", id));
        }
        return atorEncontrado;
    }

    public List<Ator> consultarAtores() throws CadastroInvalidoException {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        if (atores.size() == 0) {
            throw new CadastroInvalidoException("Nenhum ator cadastrado, favor cadastrar atores");
        }
        return atores;
    }
}
