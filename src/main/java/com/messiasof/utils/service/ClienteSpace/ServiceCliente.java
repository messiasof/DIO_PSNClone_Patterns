package com.messiasof.utils.service.ClienteSpace;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messiasof.utils.model.Cliente;
import com.messiasof.utils.model.Ender;
import com.messiasof.utils.model.RepoDoCliente;
import com.messiasof.utils.model.RepoEnder;
import com.messiasof.utils.service.ServCEP;
import com.messiasof.utils.service.ServCliente;

@Service
public class ServiceCliente implements ServCliente {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private RepoDoCliente RepoCliente;
	@Autowired
	private RepoEnder RepoEnder;
	@Autowired
	private ServCEP RepoCEP;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> allQuery() {
		// Buscar todos os Clientes.
		return RepoCliente.findAll();
	}

	@Override
	public Cliente IdQuery(Long id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = RepoCliente.findById(id);
		return cliente.get();
	}

	@Override
	public void Add(Cliente cliente) {
		SaveCli_CEP(cliente);
	}

	@Override
	public void Up(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = RepoCliente.findById(id);
		if (clienteBd.isPresent()) {
			SaveCli_CEP(cliente);
		}
	}

	@Override
	public void Del(Long id) {
		// Deletar Cliente por ID.
		RepoCliente.deleteById(id);
	}

	private void SaveCli_CEP(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEnder().queryCEP();
		Ender endereco = RepoEnder.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Ender novoEnder = RepoCEP.CheckCep(cep);
			RepoEnder.save(novoEnder);
			return novoEnder;
		});
		cliente.setEnder(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		RepoCliente.save(cliente);
	}

}
