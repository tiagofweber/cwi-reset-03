package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.FakeDatabase;
import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Diretor;
import br.com.cwi.reset.tiagofweber.repository.DiretorRepository;
import br.com.cwi.reset.tiagofweber.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        if (diretorRequest.getNome() == null || diretorRequest.getNome().equals("")) {
            throw new NomeNaoInformadoException();
        } else if (diretorRequest.getDataNascimento() == null) {
            throw new DataDeNascimentoNaoInformadaException();
        } else if (diretorRequest.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (diretorRequest.getNome().split(" ").length < 2) {
            throw new NomeSobrenomeObrigatorioException("diretor");
        }

        if (diretorRequest.getDataNascimento().isAfter(LocalDate.now())) {
            throw new DataNascimentoInvalidaException("diretores");
        }

        if (diretorRequest.getAnoInicioAtividade() <= diretorRequest.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException("diretor");
        }

        List<Diretor> diretores = diretorRepository.findAll();

        for (Diretor diretorCadastrado: diretores) {
            if (diretorCadastrado.getNome().equals(diretorRequest.getNome())) {
                throw new CadastroDuplicadoException("diretor", diretorRequest.getNome());
            }
        }

        Diretor diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()
        );

        diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {
        List<Diretor> diretores = diretorRepository.findAll();
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
        List<Diretor> diretores = diretorRepository.findAll();
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
