package com.bernardoferrari.cadastroclientes.services;

import com.bernardoferrari.cadastroclientes.dto.ClienteDTO;
import com.bernardoferrari.cadastroclientes.entities.ClienteEntity;

public interface ClienteServiceInterface {
	
	void novoCliente(ClienteDTO clienteDTO);
	
	void editarCliente(ClienteDTO clienteDTO);
	
	void removerCliente(Integer id);
	
	ClienteDTO buscarClientePorID(Integer id);
	
	ClienteDTO buscarClientePorEmail(String email);
	
	ClienteDTO buscarClientePorNome(String nome);
	
	ClienteEntity getAuthenticatedDetails();
	
	void isAdmin();
}
