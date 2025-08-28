package com.amudiel.amudiel_spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amudiel.amudiel_spring.models.TipoEntity;

@Repository
public interface TipoRepository extends CrudRepository<TipoEntity, Long>{

}
