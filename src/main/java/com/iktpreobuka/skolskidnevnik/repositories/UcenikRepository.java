package com.iktpreobuka.skolskidnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.skolskidnevnik.entities.Roditelj;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;

public interface UcenikRepository extends CrudRepository<Ucenik, Integer> {

	List<Ucenik> findAllByRoditelj(Roditelj roditelj);

}


