package com.iktpreobuka.skolskidnevnik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Odeljenje;
import com.iktpreobuka.skolskidnevnik.entities.Razred;
import com.iktpreobuka.skolskidnevnik.entities.SkolskaGodina;

@Repository
public interface GrupaRepository extends CrudRepository<Grupa, Integer> {
    Grupa findByRazredAndOdeljenjeAndSkolskaGodina(Razred razred, Odeljenje odeljenje, SkolskaGodina skolskaGodina);
}
