package com.callmatos.java.maven.demobuildjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.callmatos.java.maven.demobuildjava.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long>{
    
}
