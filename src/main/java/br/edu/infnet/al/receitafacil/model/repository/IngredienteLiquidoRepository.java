package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteLiquido;

// @Repository
public interface IngredienteLiquidoRepository extends CrudRepository<IngredienteLiquido, Integer> {

	@Query("from IngredienteLiquido il where il.usuario.id = :userId order by nome asc")
	List<IngredienteLiquido> listar(Integer userId);
}