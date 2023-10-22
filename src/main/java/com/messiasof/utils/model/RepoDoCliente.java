package com.messiasof.utils.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDoCliente extends CrudRepository<Cliente, Long> {

}