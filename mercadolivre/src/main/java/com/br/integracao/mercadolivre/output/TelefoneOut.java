package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class TelefoneOut {

	@JsonProperty("area_code")
	private String codigoArea;
	
	@JsonProperty("number")
	private String numero;
	
	@JsonProperty("extention")
	private String extencao;
	
	@JsonProperty("verified")
	private String verificado;
}
