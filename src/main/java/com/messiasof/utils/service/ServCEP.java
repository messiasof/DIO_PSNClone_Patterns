package com.messiasof.utils.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.messiasof.utils.model.Ender;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ServCEP {

	@GetMapping("/{cep}/jsonfile/")
	Ender CheckCep(@PathVariable("cep") String cep);
}
