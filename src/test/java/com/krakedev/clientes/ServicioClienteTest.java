package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

public class ServicioClienteTest {

    ServicioCliente servicio;

    @BeforeEach
    public void inicializar() {
        servicio = new ServicioCliente();
    }

    // Probar crear un cliente
    @Test
    public void testCrear() {
        Cliente cliente = new Cliente("123", "Juan", "Perez");

        Cliente resultado = servicio.crear(cliente);

        assertNotNull(resultado);
        assertEquals("123", resultado.getCedula());
        assertEquals("Juan", resultado.getNombre());
        assertEquals("Perez", resultado.getApellido());
    }

    // Probar crear un cliente duplicado
    @Test
    public void testCrearDuplicado() {
        Cliente cliente1 = new Cliente("123", "Juan", "Perez");
        Cliente cliente2 = new Cliente("123", "Pedro", "Lopez");

        servicio.crear(cliente1);

        Cliente resultado = servicio.crear(cliente2);

        assertNull(resultado);
    }

    // Probar buscar un cliente existente
    @Test
    public void testBuscarExistente() {
        Cliente cliente = new Cliente("123", "Juan", "Perez");
        servicio.crear(cliente);

        Cliente resultado = servicio.bucarPorCedula("123");

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    // Probar listar clientes
    @Test
    public void testListar() {
        servicio.crear(new Cliente("123", "Juan", "Perez"));
        servicio.crear(new Cliente("456", "Maria", "Lopez"));

        assertEquals(2, servicio.listar().size());
    }

    // Probar actualizar un cliente
    @Test
    public void testActualizar() {
        Cliente cliente = new Cliente("123", "Juan", "Perez");
        servicio.crear(cliente);

        Cliente actualizado = new Cliente("123", "Carlos", "Gomez");

        Cliente resultado = servicio.actualizar("123", actualizado);

        assertNotNull(resultado);
        assertEquals("Carlos", resultado.getNombre());
        assertEquals("Gomez", resultado.getApellido());
    }
}
