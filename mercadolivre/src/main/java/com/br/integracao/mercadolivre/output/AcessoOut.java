package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class AcessoOut {

	@JsonProperty("access_token")
	private String tokenAcesso;
	
	@JsonProperty("token_type")
	private String tipoToken;
	
	@JsonProperty("expires_in")
	private String expiracao;
	
	@JsonProperty("scope")
	private String escopo;
	
	@JsonProperty("user_id")
	private String usuario;
	
	@JsonProperty("refresh_token")
	private String codeAlterado;
	
	
}
