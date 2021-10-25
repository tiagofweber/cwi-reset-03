package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    Diretor findByNome(String nome);
    List<Diretor> findByNomeContaining(String filtroNome);
    List<Diretor> findAll();
}
