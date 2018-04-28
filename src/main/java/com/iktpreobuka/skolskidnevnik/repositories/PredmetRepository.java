package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iktpreobuka.skolskidnevnik.entities.Predmet;

@Repository
public interface PredmetRepository extends CrudRepository<Predmet, Integer> {

}
