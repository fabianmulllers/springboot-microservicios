package com.fmuller.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fmuller.springboot.app.item.clientes.ProductosClienteRest;
import com.fmuller.springboot.app.item.models.Item;
import com.fmuller.springboot.app.commons.models.entity.Producto;

@Service("serviceFeign")
public class ItemServiceFeign implements IItemService {
	
	@Autowired
	private ProductosClienteRest  clienteFeign;

	@Override
	public List<Item> findAll() {
		
		return  clienteFeign.listar().stream().map( p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(clienteFeign.detalle(id),cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeign.editar(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeign.eliminar(id);
	}

}
