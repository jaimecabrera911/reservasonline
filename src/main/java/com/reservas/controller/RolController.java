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
import com.reservas.service.RolService;

@Controller
@RequestMapping("/views/roles/")
public class RolController {

	@Autowired
	RolService rolService;

	@GetMapping("/")
	public String listaRoles(Model model) {
		List<Rol> listaRoles = rolService.listarRoles();
		model.addAttribute("titulo", "Lista de Roles");
		model.addAttribute("listaRoles", listaRoles);
		return "/views/roles/listar";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		Rol rol = new Rol();
		model.addAttribute("titulo", "Crear Roles");
		model.addAttribute("rol", rol);
		return "views/roles/crear";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("rol") Rol rol) {
		if (rol != null) {
			rolService.guardar(rol);
			return "redirect:/views/roles/";
		}
		return "views/roles/";
	}
	
	@GetMapping("/ver/{idRol}")
	public String ver(@PathVariable(value = "idRol") long id, Model model) {
		Rol rol=rolService.buscarPorID(id);
		model.addAttribute("rol", rol);
		return "/views/roles/ver";
	}
	
	
	@GetMapping("/editar/{idRol}")
	public String editar(@PathVariable(value = "idRol") long idRol, Model model) {
		Rol rol=rolService.buscarPorID(idRol);
		model.addAttribute("titulo","Modificar Cliente");
		model.addAttribute("rol", rol);
		return "/views/roles/editar";
	}

	@GetMapping("/eliminar/{idRol}")
	public String eliminar(@PathVariable(value = "idRol") long id) {
		rolService.eliminar(id);
		return "redirect:/views/roles/";
	}

	

}
