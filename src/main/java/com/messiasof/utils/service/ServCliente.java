package com.messiasof.utils.service;

import com.messiasof.utils.model.Cliente;

public interface ServCliente {

	Iterable<Cliente> allQuery();

	Cliente IdQuery(Long id);

	void Add(Cliente cliente);

	void Up(Long id, Cliente cliente);

	void Del(Long id);

}
