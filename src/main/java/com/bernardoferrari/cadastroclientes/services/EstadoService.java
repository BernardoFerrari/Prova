package com.bernardoferrari.cadastroclientes.services;

import com.bernardoferrari.cadastroclientes.dto.EstadoDTO;
import com.bernardoferrari.cadastroclientes.entities.EstadoEntity;

public interface EstadoService {
	
	void cadastrarEstado(EstadoDTO estadoDTO);
	
	EstadoEntity findBySigla(String sigla);
}
