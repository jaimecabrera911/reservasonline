package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.reservas.entity.Usuario;
import com.reservas.repository.UsuarioRepository;


@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarPorID(long id) {

		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		usuarioRepository.deleteById(id);
	}

}
