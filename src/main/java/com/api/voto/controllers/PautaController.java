package com.api.voto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.voto.entity.Pauta;
import com.api.voto.service.impl.PautaService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/pauta")
public class PautaController {

	@Autowired
	PautaService pautaService;	
	
	@PostMapping("/criar")
	public Mono<Pauta> criar(@RequestBody Pauta pauta) {
		log.info("Criando Pauta:{}", pauta);
		return pautaService.salvar(pauta);
	}		
}
