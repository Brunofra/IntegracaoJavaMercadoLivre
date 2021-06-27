package com.br.integracao.mercadolivre.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class TransacoesCompradorOut {

	@JsonProperty("period")
	private String periodo;
	
	@JsonProperty("total")
	private BigDecimal total;
	
	@JsonProperty("completed")
	private BigDecimal completo;
	
	@JsonProperty("canceled")
	private CancelamentoOut cancelamento;
	
	@JsonProperty("unrated")
	private CancelamentoOut semClassificacao;
	
	@JsonProperty("not_yet_rated")
	private CancelamentoOut naoAvaliado;
	
	@JsonProperty("tags")
	private String[] tags;
}
