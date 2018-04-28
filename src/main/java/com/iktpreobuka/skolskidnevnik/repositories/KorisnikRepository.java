package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.skolskidnevnik.entities.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
	
//	Korisnik findByMealDescription(String description);
    Korisnik findByKorisnickoIme(String korisnickoIme);

}
