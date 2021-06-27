package com.br.integracao.mercadolivre.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelamentoOut {

	@JsonProperty("total")
	private BigDecimal total;
	@JsonProperty("paid")
	private BigDecimal pagamento;
	
	@JsonProperty("units")
	private BigDecimal unidades;
}
