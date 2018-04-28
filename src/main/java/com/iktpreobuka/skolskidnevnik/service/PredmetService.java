package com.iktpreobuka.skolskidnevnik.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.skolskidnevnik.dto.PredajeDto;
import com.iktpreobuka.skolskidnevnik.dto.PredmetDto;
import com.iktpreobuka.skolskidnevnik.entities.Predaje;
import com.iktpreobuka.skolskidnevnik.entities.Predmet;



public interface PredmetService {

	ResponseEntity<List<Predaje>> nadjiNastavnikovePredmete(Integer idNastavnik, boolean izTekuceSkolskeGodine);
	ResponseEntity<Predmet> dodaj(PredmetDto predmetDto);
	ResponseEntity<Predaje> dodajPredaje(PredajeDto predjeDto);
	


}
