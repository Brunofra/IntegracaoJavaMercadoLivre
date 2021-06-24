package com.br.integracao.mercadolivre.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.integracao.mercadolivre.models.Token;

public interface TokenRepository extends CrudRepository<Token, String> {

	
	Token findById(long id);
}
