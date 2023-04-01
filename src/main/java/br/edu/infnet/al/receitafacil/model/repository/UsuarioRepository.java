package br.edu.infnet.al.receitafacil.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import br.edu.infnet.al.receitafacil.model.domain.Usuario;

// @Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario order by nome asc")
	List<Usuario> listar();

	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	Usuario autenticar(String email, String senha);
}