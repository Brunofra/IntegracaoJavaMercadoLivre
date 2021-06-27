package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class IdentificacaoOut {

	@JsonProperty("Type")
	private String tipo;
	
	@JsonProperty("number")
	private String numero;
}
