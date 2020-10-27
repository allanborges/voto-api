package com.api.voto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Sessao {	
	
	@Id
	private String id;	
	@DBRef
	private Pauta pauta;	
	private String idPauta;
	private String status;
	
	public Sessao() {
		
	}
	
}
