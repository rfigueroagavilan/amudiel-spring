package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.models.CervezaEntity;

import java.util.Optional;

@Repository
public interface CervezaRepository extends CrudRepository<CervezaEntity, Long>{

    Optional<CervezaEntity> findByUsername(String nombre);
    

}
