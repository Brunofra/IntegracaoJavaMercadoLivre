package com.br.integracao.mercadolivre.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.integracao.mercadolivre.models.Acesso;

public interface AcessoRepository extends CrudRepository<Acesso, String> {

	Acesso findById(long id);
}
