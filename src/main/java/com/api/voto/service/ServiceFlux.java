package com.api.voto.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceFlux<T> {
	Flux<T> buscarTodos();
	Mono<T> buscarPorId(String id);	
	Mono<T> salvar(T entity);
}
