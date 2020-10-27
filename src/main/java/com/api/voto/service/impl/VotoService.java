package com.api.voto.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.voto.dto.InformacaoVotoDTO;
import com.api.voto.entity.Voto;
import com.api.voto.enums.StatusEnum;
import com.api.voto.exception.VotoException;
import com.api.voto.repository.PautaRepository;
import com.api.voto.repository.SessaoRepository;
import com.api.voto.repository.VotoRepository;
import com.api.voto.service.ServiceFlux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VotoService implements ServiceFlux<Voto> {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private AssociadoService associadoService;

	@Override
	public Flux<Voto> buscarTodos() {
		return votoRepository.findAll();
	}

	@Override
	public Mono<Voto> buscarPorId(String id) {
		return votoRepository.findById(id);
	}

	@Override
	public Mono<Voto> salvar(Voto entity) {
		return votoRepository.save(entity);
	}
	
	public Mono<Voto> receberVoto(final InformacaoVotoDTO infoVotoDTO) {
		return receberVotoAssociado(infoVotoDTO);
	}
	
	private Mono<Voto> receberVotoAssociado(final InformacaoVotoDTO infoVotoDTO) {
		//TODO fazer lógica para ver se já foi votado na pauta.
		return  sessaoRepository.findByStatus(StatusEnum.ABERTA.toString()).
				next().
				flatMap(sessaoAberta -> {
					return associadoService.buscarPorId(infoVotoDTO.getIdAssociado()).flatMap(associado -> {
						Voto voto = new Voto();
						voto.setAssociado(associado);
						voto.setIdPauta(sessaoAberta.getIdPauta());
						return votoRepository.save(voto);
					});
				});		
	}

}
