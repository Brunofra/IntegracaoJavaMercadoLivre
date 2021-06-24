package com.br.integracao.mercadolivre.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Entity
@Table(name = "token")
public @Data class Token implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	private String tokenAcesso;
	
	private String tipoToken;
	
	private String expiracao;
	
	private String escopo;
	
	private String usuario;
	
	private String codeAlterado;
	
	
	
	
}
