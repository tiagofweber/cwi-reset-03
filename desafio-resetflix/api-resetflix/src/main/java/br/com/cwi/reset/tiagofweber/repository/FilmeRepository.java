package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.Filme;
import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

    Filme findByNome(String nome);
    List<Filme> findByNomeContainingIgnoreCase(String nomeFilme);
    List<Filme> findByDiretorNomeContainingIgnoreCase(String nomeDiretor);
    List<Filme> findByPersonagensNomePersonagemContainingIgnoreCase(String nomePersonagem);
    List<Filme> findByPersonagensAtorNomeContainingIgnoreCase(String nomeAtor);
    List<Filme> findAll();
}
