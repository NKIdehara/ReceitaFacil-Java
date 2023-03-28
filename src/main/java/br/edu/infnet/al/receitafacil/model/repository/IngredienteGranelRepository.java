package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.IngredienteGranel;

@Repository
public interface IngredienteGranelRepository extends CrudRepository<IngredienteGranel, Integer> {

	@Query("from IngredienteGranel ig where ig.usuario.id = :userId")
	List<IngredienteGranel> listar(Integer userId);
}