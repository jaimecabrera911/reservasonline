package com.reservas.repository;

import org.springframework.data.repository.CrudRepository;

import com.reservas.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
}
