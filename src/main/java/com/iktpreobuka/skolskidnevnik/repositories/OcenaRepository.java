package com.iktpreobuka.skolskidnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;

@CrossOrigin(origins = "http://localhost:4200")
public interface OcenaRepository extends CrudRepository<Ocena, Integer>{
	List<Ocena> findAllByOrderByVremeOcenjivanja(Ucenik ucenik);

}
