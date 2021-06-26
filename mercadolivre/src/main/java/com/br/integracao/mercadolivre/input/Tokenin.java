package com.br.integracao.mercadolivre.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({"id"})
public @Data class Tokenin {
	
	@JsonProperty("id")
	private long id;

}
