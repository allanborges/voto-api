package com.api.voto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document
@AllArgsConstructor
@Getter
@Setter
public class Associado {

	@Id
	private String id;
	private String nome;
	
	public Associado() {		
	
	}	
	
}
