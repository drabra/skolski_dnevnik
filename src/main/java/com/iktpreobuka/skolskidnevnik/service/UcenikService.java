package com.iktpreobuka.skolskidnevnik.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.util.DecijeOcene;

public interface UcenikService {
	
	ResponseEntity<List<Ocena>> pregledOcena(int idUcenik);

	ResponseEntity<List<DecijeOcene>> pregledDecijihOcena(int idRoditelja);

}
