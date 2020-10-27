package com.api.voto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.voto.entity.Associado;
import com.api.voto.repository.AssociadoRepository;
import com.api.voto.service.ServiceFlux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AssociadoService implements ServiceFlux<Associado>{
	
	@Autowired
	AssociadoRepository associadoRepository;

	@Override
	public Flux<Associado> buscarTodos() {
		return associadoRepository.findAll();
	}

	@Override
	public Mono<Associado> buscarPorId(String id) {
		return associadoRepository.findById(id);
	}

	@Override
	public Mono<Associado> salvar(Associado entity) {
		return associadoRepository.save(entity);
	}

}
