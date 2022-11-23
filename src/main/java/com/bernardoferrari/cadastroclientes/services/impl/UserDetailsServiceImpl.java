package com.bernardoferrari.cadastroclientes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bernardoferrari.cadastroclientes.entities.ClienteEntity;
import com.bernardoferrari.cadastroclientes.repositories.ClienteRepository;
import com.bernardoferrari.cadastroclientes.security.UserAuthentication;


/*
 * Classe que implementa o contrato de autenticação do usuário padrão do Spring Security.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Usamos o email, ao invés do username
		ClienteEntity cliente = repository.findByEmail(email).orElseGet(() -> {
			throw new UsernameNotFoundException("User not found with email: " + email);
		});
		
		return new UserAuthentication(cliente.getId(), cliente.getNomeCompleto(), cliente.getEmail(), cliente.getSenha());
	}
}