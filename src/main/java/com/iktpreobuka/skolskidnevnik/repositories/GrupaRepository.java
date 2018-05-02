package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Odeljenje;
import com.iktpreobuka.skolskidnevnik.entities.Razred;
import com.iktpreobuka.skolskidnevnik.entities.SkolskaGodina;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface GrupaRepository extends CrudRepository<Grupa, Integer> {
    Grupa findByRazredAndOdeljenjeAndSkolskaGodina(Razred razred, Odeljenje odeljenje, SkolskaGodina skolskaGodina);
}
