package com.iktpreobuka.skolskidnevnik.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.skolskidnevnik.dto.OcenaDto;
import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.service.OcenaService;
import com.iktpreobuka.skolskidnevnik.service.UcenikService;
import com.iktpreobuka.skolskidnevnik.util.DecijeOcene;

@RestController
@RequestMapping(path = "/ocene")
public class OcenaController {

	@Autowired
	private UcenikService ucenikService;

	@Autowired
	private OcenaService ocenaService;

	@RequestMapping("/pregledUcenikovih")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Ocena>> pregledUcenikovih(@RequestParam(value = "idUcenik") String idUcenik) {
		return ucenikService.pregledOcena(Integer.parseInt(idUcenik));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/oceni")
	public ResponseEntity oceni(@RequestBody OcenaDto ocena) {
		if (ocena.getIdUcenik() == null) {
			return new ResponseEntity("Ucenik nije odabran.", HttpStatus.BAD_REQUEST);
		}
		if (ocena.getIdNastavnik() == null) {
			return new ResponseEntity("Nastavnik nije odabran.", HttpStatus.BAD_REQUEST);
		}
		if (ocena.getIdPredmet() == null) {
			return new ResponseEntity("Predmet nije odabran.", HttpStatus.BAD_REQUEST);
		}
		if (ocena.getIdGrupa() == null) {
			return new ResponseEntity("Grupa nije odabrana", HttpStatus.BAD_REQUEST);
		}
		if (ocena.getOcena() == null) {
			return new ResponseEntity("Ocena nije uneta.", HttpStatus.BAD_REQUEST);
		}
		if (ocena.getPolugodiste() == null) {
			return new ResponseEntity("Polugodiste nije odabrano", HttpStatus.BAD_REQUEST);
		}
		if (ocena.getZakljucnaOcena() == null) {
			return new ResponseEntity("Nije odabrano da li je ocena zakljucna.", HttpStatus.BAD_REQUEST);
		}
		return ocenaService.oceni(ocena);
	}

	@RequestMapping("/pregledDecijihOcena")
	public ResponseEntity<List<DecijeOcene>> pregledDecijihOcena(
			@RequestParam(value = "idRoditelj") String idRoditelj) {
		return ucenikService.pregledDecijihOcena(Integer.parseInt(idRoditelj));
	}
}
