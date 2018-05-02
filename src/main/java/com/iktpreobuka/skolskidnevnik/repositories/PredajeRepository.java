package com.iktpreobuka.skolskidnevnik.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Nastavnik;
import com.iktpreobuka.skolskidnevnik.entities.Predaje;
import com.iktpreobuka.skolskidnevnik.entities.Predmet;

@CrossOrigin(origins = "http://localhost:4200")
public interface PredajeRepository extends CrudRepository<Predaje, Integer> {
	Predaje findByNastavnikAndGrupaAndPredmet(Nastavnik nastavnik, Grupa grupa, Predmet predmet);

    @Query("from Predaje as pr left join pr.predmet as p left join pr.nastavnik as n left join pr.grupa as g left join g.skolskaGodina as sg where n.idNastavnik = :idNastavnik and sg.trenutna = :tekuca")
    List<Predaje> findAllByNastavnikAndTekucaGodina(@Param("idNastavnik")int idNastavnik, @Param("tekuca")boolean tekuca);


}
