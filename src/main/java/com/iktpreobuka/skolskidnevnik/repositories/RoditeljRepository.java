package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Roditelj;

@CrossOrigin(origins = "http://localhost:4200")
public interface RoditeljRepository extends CrudRepository<Roditelj, Integer> {

}
