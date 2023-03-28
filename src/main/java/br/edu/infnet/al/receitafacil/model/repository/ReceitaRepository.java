package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer> {

	@Query("from Receita r where r.usuario.id = :userId")
	List<Receita> listar(Integer userId);
}