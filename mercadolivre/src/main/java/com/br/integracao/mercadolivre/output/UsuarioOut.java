package com.br.integracao.mercadolivre.output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public @Data class UsuarioOut {

	@JsonProperty("id")
	private String idUsuario;
	
	@JsonProperty("nickname")
	private String nickName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("site_status")
	private String siteStatus;
	
	@JsonProperty("registration_date")
	private String dataRegistro;
	
	@JsonProperty("first_name")
	private String primeiroNome;
	
	@JsonProperty("last_name")
	private String sobreNome;
	
	@JsonProperty("country_id")
	private String idPais;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("identification")
	private IdentificacaoOut identificacao;
	
	@JsonProperty("address")
	private EnderecoOut endereco;
	
	@JsonProperty("phone")
	private TelefoneOut telefone;
	
	@JsonProperty("alternative_phone")
	private TelefoneOut telefoneAlternativo;
	
	@JsonProperty("user_type")
	private String tipousuario;
	
	@JsonProperty("tags")
	private String[] tags;
	
	@JsonProperty("logo")
	private String logo;
	
	@JsonProperty("point")
	private BigDecimal point;
	
	@JsonProperty("site_id")
	private String idSite;
	
	@JsonProperty("permalink")
	private String permalink;
	
	@JsonProperty("shipping_modes")
	private ModoEntregaOut modoentrega;
	
	@JsonProperty("seller_experience")
	private String experienciaVendedor;
	
	@JsonProperty("seller_reputation")
	private ReputacaoVendedorOut reputacaoVendedor;
	
//	@JsonProperty("buyer_reputation")
//	private reputacaoCompradorOut reputacaoComprador;
	
	
	
	
	
}
