package com.iktpreobuka.skolskidnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Roditelj;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;

@CrossOrigin(origins = "http://localhost:4200")
public interface UcenikRepository extends CrudRepository<Ucenik, Integer> {

	List<Ucenik> findAllByRoditelj(Roditelj roditelj);

}


