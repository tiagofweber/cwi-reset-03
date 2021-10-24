package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {
}
