package com.iktpreobuka.skolskidnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;

public interface OcenaRepository extends CrudRepository<Ocena, Integer>{
	List<Ocena> findAllByOrderByVremeOcenjivanja(Ucenik ucenik);

}
