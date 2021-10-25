package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    List<Estudio> findAll();
}
