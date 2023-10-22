package com.messiasof.utils.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEnder extends CrudRepository<Ender, String> {

}