package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.Cozinheiro;

@Repository
public interface CozinheiroRepository extends CrudRepository<Cozinheiro, Integer> {

	@Query("from Cozinheiro c where c.usuario.id = :userId")
	List<Cozinheiro> listar(Integer userId);
}