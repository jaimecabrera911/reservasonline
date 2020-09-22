package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reservas.entity.Usuario;
import com.reservas.service.UsuarioService;

@Controller
@RequestMapping("/views/usuarios/")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios=usuarioService.listarUsuarios();
		model.addAttribute("titulo","Lista de Usuarios");
		model.addAttribute("listaUsuarios",listaUsuarios);
		return "/views/usuarios/listar";
	}

}
