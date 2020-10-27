package com.api.voto.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.api.voto.entity.Associado;

@Repository
public interface AssociadoRepository extends ReactiveMongoRepository<Associado, String>{

}
