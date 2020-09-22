package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reservas.entity.Rol;
import com.reservas.entity.Usuario;
import com.reservas.service.RolService;
import com.reservas.service.UsuarioService;

@Controller
@RequestMapping("/views/usuarios/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "/views/usuarios/listar";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		List<Rol> listaRoles = rolService.listarRoles();
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Registro Usuarios");
		model.addAttribute("listaRoles", listaRoles);
		model.addAttribute("usuario", usuario);
		return ("/views/usuarios/crear");
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("usuario") Usuario usuario) {
		System.out.println(usuario);
		usuarioService.guardar(usuario);
		return ("redirect:/views/usuarios/");
	}

	@GetMapping("/ver/{idUsuario}")
	public String ver(@PathVariable(value = "idUsuario") long id, Model model) {
		Usuario usuario = usuarioService.buscarPorID(id);
		model.addAttribute("titulo", "Ver Usuario");
		model.addAttribute("usuario", usuario);
		return ("/views/usuarios/ver");
	}
	

	@GetMapping("/editar/{idUsuario}")
	public String editar(@PathVariable(value = "idUsuario") long id, Model model) {
		List<Rol> listaRoles = rolService.listarRoles();
		Usuario usuario = usuarioService.buscarPorID(id);
		model.addAttribute("titulo", "Editar Usuario");
		model.addAttribute("listaRoles", listaRoles);
		model.addAttribute("usuario", usuario);
		return ("/views/usuarios/editar");
	}
	
	@GetMapping("/eliminar/{idUsuario}")
	public String eliminar(@PathVariable(value = "idUsuario") long id) {
		usuarioService.eliminar(id);
		return ("redirect:/views/usuarios/");
	}
}
