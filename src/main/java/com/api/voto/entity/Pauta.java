package com.api.voto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pauta {
	
	@Id
	private String id;
	private String nome;
		
	public Pauta() {		
	}		
}
