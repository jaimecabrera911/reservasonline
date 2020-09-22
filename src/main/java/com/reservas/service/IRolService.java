package com.reservas.service;

import java.util.List;


import com.reservas.entity.Rol;


public interface IRolService {
	
	public List<Rol> listarRoles();
	
	public void guardar(Rol rol);
	
	public Rol buscarPorID(long id);
	
	public void eliminar(long id);

}
