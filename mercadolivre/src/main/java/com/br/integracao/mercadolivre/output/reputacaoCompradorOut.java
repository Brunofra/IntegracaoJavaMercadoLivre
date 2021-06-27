package com.br.integracao.mercadolivre.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public  class reputacaoCompradorOut {

	@JsonProperty("canceled_transations")
	private BigDecimal transacoesCanceladas;
	
	@JsonProperty("transactions")
	private TransacoesCompradorOut transacoes;
}
