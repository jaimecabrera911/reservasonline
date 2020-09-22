package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.entity.Rol;
import com.reservas.repository.RolRepository;

@Service
public class RolService implements IRolService {

	@Autowired
	RolRepository rolRepository;

	Rol rol = new Rol();

	@Override
	public List<Rol> listarRoles() {
		return (List<Rol>) rolRepository.findAll();
	}

	@Override
	public void guardar(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public Rol buscarPorID(long id) {
		return rolRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		rolRepository.deleteById(id);
	}

}
