package com.api.voto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.voto.entity.Voto;

public interface VotoRepository extends ReactiveMongoRepository<Voto, String> {

}
