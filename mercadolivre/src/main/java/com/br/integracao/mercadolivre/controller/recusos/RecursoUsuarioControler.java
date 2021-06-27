package com.br.integracao.mercadolivre.controller.recusos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.br.integracao.mercadolivre.input.RecursosIn;
import com.br.integracao.mercadolivre.models.Usuarios;
import com.br.integracao.mercadolivre.output.UsuarioOut;
import com.br.integracao.mercadolivre.repository.UsuariosRepository;

@Controller
@RequestMapping("/start/recursos/*")
public class RecursoUsuarioControler {
	@Autowired
	private UsuariosRepository user;
	@GetMapping("/users")
	@ResponseBody
	public ResponseEntity<?> getusers(@RequestBody RecursosIn recurso)throws Exception{
		//Usuarios user = this.user.findByIdUsuario(recurso.getIdusuario());
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate rest = new RestTemplate();
		
		ResponseEntity<UsuarioOut> response = rest.getForEntity("https://api.mercadolibre.com/users/781462195",UsuarioOut.class);
//		if(response.hasBody()) {
//			UsuarioOut user = response.getBody();
//			return user;
//		}else {
//			return null;
//		}
	
		return response;
	}
}
