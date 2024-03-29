package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    Estudio findByIdEquals(Integer id);
    Estudio findByNome(String nome);
    List<Estudio> findByNomeContaining(String filtroNome);
    List<Estudio> findAll();
}
