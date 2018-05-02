package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Predmet;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface PredmetRepository extends CrudRepository<Predmet, Integer> {

}
