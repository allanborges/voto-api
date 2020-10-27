package com.api.voto.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.voto.entity.Sessao;

import reactor.core.publisher.Flux;

public interface SessaoRepository extends ReactiveMongoRepository<Sessao, String>{
	
	@Query(value = "{ 'status' : ?0 }", fields = "{'idPauta': 1}" )
	Flux<Sessao> findByStatus(String status);

}
