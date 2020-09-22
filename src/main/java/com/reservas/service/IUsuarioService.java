package com.reservas.service;

import java.util.List;


import com.reservas.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();

	public void guardar(Usuario usuario);

	public Usuario buscarPorID(long id);

	public void eliminar(long id);

}
