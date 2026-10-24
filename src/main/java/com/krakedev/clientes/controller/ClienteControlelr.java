package com.krakedev.clientes.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

import java.util.List;

@RestController

@RequestMapping("/Clientes")
public class ClienteControlelr {

	private final ServicioCliente servicioCliente = new ServicioCliente();

	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return servicioCliente.crear(cliente);
	}

	@GetMapping
	public List<Cliente> listar() {
		return servicioCliente.listar();
	}

	@GetMapping("/{cedula}")
	public Cliente buscar(@PathVariable String cedula) {
		return servicioCliente.bucarPorCedula(cedula);
	}
	
	@PutMapping("/{cedula}")
	public Cliente actualizat(@PathVariable String cedula, @RequestBody Cliente ClienteActualizado) {
		return servicioCliente.actualizar(cedula, ClienteActualizado);
	}
	
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicioCliente.eliminar(cedula);
	}
	
}
