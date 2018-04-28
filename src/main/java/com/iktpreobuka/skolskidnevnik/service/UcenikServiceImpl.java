package com.iktpreobuka.skolskidnevnik.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.entities.Roditelj;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;
import com.iktpreobuka.skolskidnevnik.repositories.OcenaRepository;
import com.iktpreobuka.skolskidnevnik.repositories.RoditeljRepository;
import com.iktpreobuka.skolskidnevnik.repositories.UcenikRepository;
import com.iktpreobuka.skolskidnevnik.util.DecijeOcene;



public class UcenikServiceImpl implements UcenikService {
	
	@Autowired
	UcenikRepository ucenikRepository;
	
	@Autowired
	OcenaRepository ocenaRepository;
	
	@Autowired
	RoditeljRepository roditeljRepository;
	
	@Override
	public ResponseEntity<List<Ocena>> pregledOcena(int idUcenik) {
		Ucenik ucenik = ucenikRepository.findOne(idUcenik);
		if (ucenik == null) {
			return new ResponseEntity("Los zahtev", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ocenaRepository.findAllByOrderByVremeOcenjivanja(ucenik), HttpStatus.OK);
		}

	@Override
	@Transactional
	public ResponseEntity<List<DecijeOcene>> pregledDecijihOcena(int idRoditelja) {
		Roditelj roditelj = roditeljRepository.findOne(idRoditelja);
		if (roditelj == null) {
			return new ResponseEntity("Los zahtev", HttpStatus.BAD_REQUEST);
		}
		List<Ucenik> decaRoditelja = ucenikRepository.findAllByRoditelj(roditelj);
		if (decaRoditelja.size() < 1) {
			return new ResponseEntity("Roditelj bez dece u sistemu", HttpStatus.BAD_REQUEST);
		}
		List<DecijeOcene> decijeOcenes = new ArrayList<>();
		for (Ucenik ucenik : decaRoditelja) {
			DecijeOcene decijeOcene = new DecijeOcene();
			decijeOcene.setUcenik(ucenik);
			decijeOcene.setOcene(ocenaRepository.findAllByOrderByVremeOcenjivanja(ucenik));
			decijeOcenes.add(decijeOcene);
		}
		return new ResponseEntity(decijeOcenes, HttpStatus.OK);
			
		
	}
	}
	
	
	


