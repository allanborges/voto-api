package com.api.voto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.voto.entity.Sessao;
import com.api.voto.service.impl.SessaoService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/sessao")
public class SessaoController {
	
	@Autowired
	private SessaoService sessaoService;

	@PostMapping(value = "/abrir/{idPauta}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Mono<Sessao> abrirSessao(@PathVariable String idPauta) {
		log.info("Abrindo uma Sessao na Pauta {}", idPauta);			
		return sessaoService.abrirSessao(idPauta);					
	}
}
