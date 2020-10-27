package com.api.voto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.voto.entity.Pauta;

public interface PautaRepository extends ReactiveMongoRepository<Pauta, String>{

}
