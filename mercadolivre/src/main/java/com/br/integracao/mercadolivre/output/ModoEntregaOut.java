package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class ModoEntregaOut {

	@JsonProperty("custom")
	private String personalizado;
	
	@JsonProperty("no_especified")
	private String naoEspecifico;
}
