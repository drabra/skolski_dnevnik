package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.skolskidnevnik.entities.SkolskaGodina;

public interface SkolskaGodinaRepository extends CrudRepository<SkolskaGodina, Integer> {
	SkolskaGodina findByTrenutnaIsTrue();

}
