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
	
//http://auth.mercadolivre.com.br/authorization?response_type=code&client_id=2297576782702767&redirect_uri=https://mercadolivre.com.br
	private long id;
	
	
	private String appId; //ID: 2297576782702767

	
	private String code; //TG-60d3d9ca6243370007c1ea79-779973219
	
	
	private String redirecionamento; //https://mercadolivre.com.br
	
	
	private String senhaUsuario;
	
	private String grantType;
	
	private String linkAutorizacao;

}
