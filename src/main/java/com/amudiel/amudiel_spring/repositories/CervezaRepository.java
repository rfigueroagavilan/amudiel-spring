package com.amudiel.amudiel_spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amudiel.amudiel_spring.models.CervezaEntity;

import java.util.Optional;

@Repository
public interface CervezaRepository extends CrudRepository<CervezaEntity, Long>{

    Optional<CervezaEntity> findByNombre(String nombre);
    

}
