package com.bernardoferrari.cadastroclientes.services;

import java.util.List;

import com.bernardoferrari.cadastroclientes.dto.CidadeDTO;
import com.bernardoferrari.cadastroclientes.dto.CidadeDTO.CidadeInterfaceDTO;
import com.bernardoferrari.cadastroclientes.entities.CidadeEntity;

public interface CidadeService {
	
	void cadastrarCidade(CidadeDTO cidadeDTO);
	
	CidadeEntity buscarPorNome(String nome);
	
	CidadeDTO buscarPorNomeDTO(String nome);
	
	CidadeEntity buscarPorNomeAndSiglaEstado(String nome, String siglaEstado);
	
	List<CidadeInterfaceDTO> buscaCidadePeloNomeEstado(String nome, Integer limite, Integer offset);
	
	List<CidadeInterfaceDTO> buscaCidadePelaSiglaEstado(String sigla, Integer limite, Integer offset);
}
