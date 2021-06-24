package com.br.integracao.mercadolivre.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
import com.br.integracao.mercadolivre.models.Acesso;
import com.br.integracao.mercadolivre.output.AcessoOut;
import com.br.integracao.mercadolivre.repository.AcessoRepository;

@Controller
@RequestMapping("/start/*")
public class AcessoController {

	@Autowired
	private AcessoRepository er;

	@GetMapping("/token")
	@ResponseBody

	public AcessoOut gettoken(@RequestBody AcessoIn id) throws Exception {
		Acesso acesso = er.findById(id.getId());
		RestTemplate redirect = new RestTemplate();
		ResponseEntity<String> get = redirect.exchange(acesso.getLinkAutorizacao(), HttpMethod.GET, null, String.class);
		String code = get.getBody();
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
			
			return out;
		}
		else {
			return null;
		}

	}
}
