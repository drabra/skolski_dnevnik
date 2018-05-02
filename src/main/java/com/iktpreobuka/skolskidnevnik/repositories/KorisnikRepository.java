package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Korisnik;

@CrossOrigin(origins = "http://localhost:4200")
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
	
//	Korisnik findByMealDescription(String description);
    Korisnik findByKorisnickoIme(String korisnickoIme);

}
