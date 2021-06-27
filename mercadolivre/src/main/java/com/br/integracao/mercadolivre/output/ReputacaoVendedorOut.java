package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class ReputacaoVendedorOut {

	@JsonProperty("level_id")
	private String nivelId;
	
	@JsonProperty("power_seller_status")
	private String podervenda;
	
	@JsonProperty("transactions")
	private TransacaoOut transacao;
	
}
