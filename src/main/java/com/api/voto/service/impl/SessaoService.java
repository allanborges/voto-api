package com.api.voto.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api.voto.entity.Pauta;
import com.api.voto.entity.Sessao;
import com.api.voto.enums.StatusEnum;
import com.api.voto.repository.PautaRepository;
import com.api.voto.repository.SessaoRepository;
import com.api.voto.service.ServiceFlux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SessaoService implements ServiceFlux<Sessao>{
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Value("${sessaoVotacao.tempo}")
	private Long tempoSessao;

	@Override
	public Flux<Sessao> buscarTodos() {
		return sessaoRepository.findAll();
	}

	@Override
	public Mono<Sessao> buscarPorId(String id) {
		return sessaoRepository.findById(id);
	}

	@Override
	public Mono<Sessao> salvar(Sessao entity) {
		return sessaoRepository.save(entity);
	}
	
	public Mono<Sessao> encerrarSessao(Sessao sessao) {		
		sessao.setStatus(StatusEnum.FECHADA.toString());		
		return sessaoRepository.save(sessao);
	}
	
	public Mono<Sessao> abrirSessao(String idPauta) {
		Mono<Pauta> monoPauta = pautaRepository.findById(idPauta);	
		return monoPauta.
			map(pauta -> {
				Sessao sessao = new Sessao();
				sessao.setPauta(pauta);
				sessao.setIdPauta(pauta.getId());
				sessao.setStatus(StatusEnum.ABERTA.toString());
				return sessao;
			}).
			flatMap(sessaoRepository::save).		
			delayElement(Duration.ofSeconds(tempoSessao)).
			flatMap(this::encerrarSessao);
	}

}
