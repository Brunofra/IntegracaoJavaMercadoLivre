package com.br.integracao.mercadolivre.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public @Data class UsuarioOut {

	@JsonProperty("id")
	private String idUsuario;
	
	@JsonProperty("nickname")
	private String nickName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("site_status")
	private String siteStatus;
}
