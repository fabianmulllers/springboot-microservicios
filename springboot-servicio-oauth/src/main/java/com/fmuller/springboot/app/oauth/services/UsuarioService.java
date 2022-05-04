package com.fmuller.springboot.app.oauth.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fmuller.springboot.app.commons.usuarios.models.entity.Usuario;
import com.fmuller.springboot.app.oauth.client.IUsuarioFeignClient;

import brave.Tracer;
import feign.FeignException;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUsuarioFeignClient client;
	
	@Autowired
	private Tracer tracer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = null;

		try {
			usuario = client.findByUsername(username);

			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getNombre()))
					.peek(authority -> log.info("Role:" + authority.getAuthority())).collect(Collectors.toList());

			log.info("Usuario" + username);

			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
					authorities);

		} catch (FeignException e) {
			String error = "No se encontro al usuario con el nombre" + username;
			log.error(error);
			tracer.currentSpan().tag("error.mensaje", error + " " + e.getMessage());
			throw new UsernameNotFoundException(error);
		}

	}

	@Override
	public Usuario findByUsername(String username) {
		return client.findByUsername(username);
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		client.update(usuario, id);
		return null;
	}

}
