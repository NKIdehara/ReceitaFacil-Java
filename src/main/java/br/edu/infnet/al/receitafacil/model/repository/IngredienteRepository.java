package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.Ingrediente;

// @Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer> {

	@Query("from Ingrediente i where i.usuario.id = :userId order by nome asc")
	List<Ingrediente> listar(Integer userId);
}