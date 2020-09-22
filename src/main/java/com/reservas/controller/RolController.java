package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reservas.entity.Rol;
import com.reservas.service.RolService;

@Controller
@RequestMapping("/views/roles/")
public class RolController {

	@Autowired
	RolService rol;

	@GetMapping("/")
	public String listaRoles(Model model) {
		List<Rol> listaRoles = rol.listarRoles();
		model.addAttribute("titulo", "Lista de Roles");
		model.addAttribute("listaRoles", listaRoles);
		return "/views/roles/listar";
	}

}
