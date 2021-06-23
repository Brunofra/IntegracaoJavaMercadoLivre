package br.com.integracao.mercadolivre.Entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Token implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7307650567657994344L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private String sysPassword;
	private String token;

}
