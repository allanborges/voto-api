package com.api.voto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.voto.entity.Associado;
import com.api.voto.service.impl.AssociadoService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
		
	@PostMapping("/criar")
	public Mono<Associado> criar(@RequestBody Associado associado) {
		log.info("Criando Associado:{}", associado);
		return associadoService.salvar(associado);
	}		

}
