package com.br.integracao.mercadolivre.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "acesso")
public @Data class Acesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	

	private long id;
	
	
	private String appId; 

	
	private String code; 
	
	
	private String redirecionamento;
	
	
	private String senhaUsuario;
	
	private String grantType;

}
