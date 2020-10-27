package com.api.voto.dto;

import java.io.Serializable;

import com.api.voto.enums.VotoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InformacaoVotoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idAssociado;
	private VotoEnum voto;
	
	public InformacaoVotoDTO() {
		
	}
}
