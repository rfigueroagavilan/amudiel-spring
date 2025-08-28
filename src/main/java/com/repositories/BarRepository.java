package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends CrudRepository<BarRepository, Long>{


    
}
