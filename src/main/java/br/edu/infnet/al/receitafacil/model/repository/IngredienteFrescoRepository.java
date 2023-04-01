package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteFresco;

// @Repository
public interface IngredienteFrescoRepository extends CrudRepository<IngredienteFresco, Integer> {

	@Query("from IngredienteFresco if where if.usuario.id = :userId order by nome asc")
	List<IngredienteFresco> listar(Integer userId);
}