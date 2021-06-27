package com.br.integracao.mercadolivre.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class TransacaoOut {

	@JsonProperty("period")
	private String periodo;
	
	@JsonProperty("total")
	private BigDecimal total;
	
	@JsonProperty("completed")
	private BigDecimal completo;
	
	@JsonProperty("canceled")
	private BigDecimal cancelado;
	
	@JsonProperty("ratings")
	private AvaliacoesOut avaliacoes;
}
