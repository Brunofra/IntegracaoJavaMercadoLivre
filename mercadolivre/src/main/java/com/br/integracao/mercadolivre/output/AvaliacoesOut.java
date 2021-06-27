package com.br.integracao.mercadolivre.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class AvaliacoesOut {

	@JsonProperty("positive")
	private BigDecimal positivo;
	
	@JsonProperty("negative")
	private BigDecimal negativo;
	
	@JsonProperty("neutral")
	private BigDecimal neutro;
}
