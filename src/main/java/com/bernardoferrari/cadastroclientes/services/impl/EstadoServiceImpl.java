package com.bernardoferrari.cadastroclientes.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardoferrari.cadastroclientes.dto.EstadoDTO;
import com.bernardoferrari.cadastroclientes.entities.EstadoEntity;
import com.bernardoferrari.cadastroclientes.mappers.EstadoMapper;
import com.bernardoferrari.cadastroclientes.repositories.EstadoRepository;
import com.bernardoferrari.cadastroclientes.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@Autowired
	private EstadoMapper estadoMapper;
	
	@Override
	public void cadastrarEstado(EstadoDTO estadoDTO) {
		this.clienteService.isAdmin();
		
		estadoRepository.saveAndFlush(estadoMapper.fromDTO(estadoDTO));
	}
	
	@Override
	public EstadoEntity findBySigla(String sigla) {
		return estadoRepository.findBySiglaEstado(sigla).orElseGet(() -> {
			throw new NoSuchElementException("Nenhum Estado foi encontrado com a sigla '" + sigla + "'.");
		});
	}
}
