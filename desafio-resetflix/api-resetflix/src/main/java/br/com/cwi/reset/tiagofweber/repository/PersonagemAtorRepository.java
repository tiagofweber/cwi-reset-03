package br.com.cwi.reset.tiagofweber.repository;

import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {
}
