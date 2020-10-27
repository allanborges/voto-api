package com.api.voto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.voto.entity.Pauta;
import com.api.voto.repository.PautaRepository;
import com.api.voto.service.ServiceFlux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PautaService implements ServiceFlux<Pauta> {	
	
	@Autowired
	PautaRepository pautaRepository;

	@Override
	public Flux<Pauta> buscarTodos() {
		return pautaRepository.findAll();
	}

	@Override
	public Mono<Pauta> buscarPorId(final String id) {	
		return pautaRepository.findById(id);
	}

	@Override
	public Mono<Pauta> salvar(Pauta entity) {
		return pautaRepository.save(entity);
	}

}
