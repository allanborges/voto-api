package com.api.voto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.voto.dto.InformacaoVotoDTO;
import com.api.voto.entity.Voto;
import com.api.voto.service.impl.VotoService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/voto")
public class VotoController {
	
	@Autowired
	private VotoService votoService;
	
	@PostMapping("/receber-voto")
	public Mono<Voto> votar(@RequestBody InformacaoVotoDTO informacaoVoto) {
		log.info("recebendo voto do associado:{}", informacaoVoto);
		return votoService.receberVoto(informacaoVoto);
	}		

}
