package com.api.voto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
public class Voto {
	
	@Id
	private String id;
	
	@DBRef
	private Associado associado;
	
	@DBRef
	private Pauta pauta;	
	private String idPauta;

	public Voto() {		
	}
	

}
