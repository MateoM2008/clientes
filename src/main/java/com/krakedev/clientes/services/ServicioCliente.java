package com.krakedev.clientes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.clientes.entidades.Cliente;

@Service
public class ServicioCliente {
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();;

	public Cliente bucarPorCedula(String cedula) {
		for (Cliente c : clientes) {
			if (c.getCedula().equals(cedula)) {
				return c;
			}
		}
		return null;
	}

	public Cliente crear(Cliente cliente) {
		Cliente existente = bucarPorCedula(cliente.getCedula());

		if (existente != null) {
			return null;
		} else {
			clientes.add(cliente);
			return cliente;
		}
	}

	public List<Cliente> listar() {
		return clientes;
	}

	public Cliente actualizar(String cedula, Cliente clienteActualizado) {
		Cliente cliente = bucarPorCedula(cedula);

		if (cliente != null) {
			cliente.setNombre(clienteActualizado.getNombre());
			cliente.setApellido(clienteActualizado.getApellido());
			cliente.setEmail(clienteActualizado.getEmail());

		}
		return cliente;
	}

	public boolean eliminar(String cedula) {
		Cliente cliente = bucarPorCedula(cedula);

		if (cliente != null) {
			clientes.remove(cliente);
			return true;
		} else {
			return false;
		}

	}
}
