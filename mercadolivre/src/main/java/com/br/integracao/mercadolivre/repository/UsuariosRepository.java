package com.br.integracao.mercadolivre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import com.br.integracao.mercadolivre.models.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, String>{

	Usuarios findById(long id);
	Usuarios findByIdUsuario(String user);
}
