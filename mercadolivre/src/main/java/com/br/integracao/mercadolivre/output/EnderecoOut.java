package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class EnderecoOut {

	@JsonProperty("state")
	private String estado;
	
	@JsonProperty("city")
	private String cidade;
	
	@JsonProperty("address")
	private String endereco;
	
	@JsonProperty("zip_code")
	private String numero;
}
