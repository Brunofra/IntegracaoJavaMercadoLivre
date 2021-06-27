package com.br.integracao.mercadolivre.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public @Data class RecursosIn {
	@JsonProperty("idUsuario")
	private String Idusuario;
}
