package com.br.integracao.mercadolivre.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.br.integracao.mercadolivre.input.AcessoIn;
import com.br.integracao.mercadolivre.input.Tokenin;
import com.br.integracao.mercadolivre.models.Acesso;
import com.br.integracao.mercadolivre.models.Token;
import com.br.integracao.mercadolivre.output.AcessoOut;
import com.br.integracao.mercadolivre.repository.AcessoRepository;
import com.br.integracao.mercadolivre.repository.TokenRepository;

@Controller
@RequestMapping("/start/*")
public class AcessoController {

	@Autowired
	private AcessoRepository acesso;
	@Autowired
	private TokenRepository token;

	@GetMapping("/token")
	@ResponseBody

	public AcessoOut gettoken(@RequestBody AcessoIn id) throws Exception {
		Acesso acesso = this.acesso.findById(id.getId());
		//RestTemplate redirect = new RestTemplate();
		//ResponseEntity<String> get = redirect.exchange(acesso.getLinkAutorizacao(), HttpMethod.GET, null, String.class);
		//String code = get.getBody();
		//
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// header.setAccept(List<MediaType.APPLICATION_JSON>);
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("grant_type", acesso.getGrantType());
		parts.add("client_id", acesso.getAppId());
		parts.add("client_secret", acesso.getSenhaUsuario());
		parts.add("code", acesso.getCode());
		parts.add("redirect_uri", acesso.getRedirecionamento());
		HttpEntity<?> entity = new HttpEntity<Object>(parts, header);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<AcessoOut> response = rest.postForEntity("https://api.mercadolibre.com/oauth/token", entity,
				AcessoOut.class);
		
		if(response.hasBody()) {
			AcessoOut out = new AcessoOut();
			
			out = response.getBody();
			Token token = new Token();
			token.setTokenAcesso(out.getTokenAcesso());
			token.setExpiracao(out.getExpiracao());
			token.setEscopo(out.getEscopo());
			token.setTipoToken(out.getTipoToken());
			token.setUsuario(out.getUsuario());
			token.setCodeAlterado(out.getCodeAlterado());
			this.token.save(token);
			return out;
		}
		else {
			Tokenin to = new Tokenin();
			to.setId(id.getId());			
			return refresh(to);
		}

	}
	
	
	@GetMapping("/refreshtoken")
	@ResponseBody
	public AcessoOut refresh(@RequestBody Tokenin token) throws Exception{
		Token to = this.token.findById(token.getId());
		Acesso ac = this.acesso.findById(token.getId());
		Map<String, String> mapa = new HashMap<>();
		mapa.put("grant_type","refresh_token");
		mapa.put("client_id", ac.getAppId());
		mapa.put("client_secret", ac.getSenhaUsuario());
		mapa.put("refresh_token",to.getCodeAlterado());
		RestTemplate rest = new RestTemplate();
		ResponseEntity<AcessoOut> response = rest.postForEntity("https://api.mercadolibre.com/oauth/token", mapa, AcessoOut.class);
		if(response.hasBody()) {
			AcessoOut out = new AcessoOut();
			
			out = response.getBody();
			Token tokensave = new Token();
			tokensave.setTokenAcesso(out.getTokenAcesso());
			tokensave.setExpiracao(out.getExpiracao());
			tokensave.setEscopo(out.getEscopo());
			tokensave.setTipoToken(out.getTipoToken());
			tokensave.setUsuario(out.getUsuario());
			tokensave.setCodeAlterado(out.getCodeAlterado());
			this.token.save(tokensave);
			return out;
		}else {
			return null;
		}
	}
	
	
}
