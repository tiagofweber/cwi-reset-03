package br.com.cwi.reset.tiagofweber.service;

import br.com.cwi.reset.tiagofweber.exception.*;
import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.Diretor;
import br.com.cwi.reset.tiagofweber.repository.DiretorRepository;
import br.com.cwi.reset.tiagofweber.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        validarDiretorRequest(diretorRequest);

        Diretor diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()
        );

        diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {
        List<Diretor> diretores = diretorRepository.findAll();
        List<Diretor> diretoresFiltrados = diretorRepository.findByNomeContaining(filtroNome);

        if (diretores.size() == 0) {
            throw new DiretorNaoEncontradoException();
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

        if (!diretorRepository.existsById(id)) {
            throw new IdNaoEncontradoException("diretor", id);
        }

        return diretorRepository.findByIdEquals(id);
    }

    public void atualizarDiretor(Integer id, DiretorRequest diretorRequest) throws Exception {
        if (!diretorRepository.existsById(id)) {
            throw new IdNaoEncontradoException("diretor", id);
        }

        validarDiretorRequest(diretorRequest);

        Diretor diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()
        );

        diretor.setId(id);
        diretorRepository.save(diretor);
    }

    private void validarDiretorRequest(DiretorRequest diretorRequest) throws Exception {
        if (diretorRequest.getNome().split(" ").length < 2) {
            throw new NomeSobrenomeObrigatorioException("diretor");
        }

        if (diretorRequest.getAnoInicioAtividade() <= diretorRequest.getDataNascimento().getYear()) {
            throw new AnoInicioAtividadeInvalidoException("diretor");
        }

        Diretor diretorJaExistente = diretorRepository.findByNome(diretorRequest.getNome());

        if (diretorJaExistente != null) {
            throw new CadastroDuplicadoException("diretor", diretorRequest.getNome());
        }
    }
}
