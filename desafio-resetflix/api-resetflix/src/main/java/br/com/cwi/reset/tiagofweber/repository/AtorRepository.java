package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.Ator;
import br.com.cwi.reset.tiagofweber.model.StatusCarreira;
import br.com.cwi.reset.tiagofweber.response.AtorEmAtividade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findByIdEquals(Integer id);
    Ator findByNome(String nome);
    List<AtorEmAtividade> findByNomeContainingIgnoreCaseAndStatusCarreiraEquals(String filtroNome, StatusCarreira statusCarreira);
    List<Ator> findAll();
}
