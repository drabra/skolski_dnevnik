package com.iktpreobuka.skolskidnevnik.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.skolskidnevnik.dto.PredajeDto;
import com.iktpreobuka.skolskidnevnik.dto.PredmetDto;
import com.iktpreobuka.skolskidnevnik.entities.Predaje;
import com.iktpreobuka.skolskidnevnik.service.PredmetService;

@RestController
@RequestMapping("/predmeti")
public class PredmetController {

	@Autowired
	private PredmetService predmetService;

	@RequestMapping("/pregled-nastavnikovih")
	public ResponseEntity<List<Predaje>> pregledNastavnikovihPredmeta(
			@RequestParam(value = "idNastavnik") Integer idNastavnik,
			@RequestParam(value = "izTekuceSkolskeGodine") Boolean izTekuceSkolskeGodine) {
		if (idNastavnik == null || izTekuceSkolskeGodine == null) {
			return new ResponseEntity("Sva polja su obavezna.", HttpStatus.BAD_REQUEST);
		}
		return predmetService.nadjiNastavnikovePredmete(idNastavnik, izTekuceSkolskeGodine);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dodaj-predmet")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity dodajPredmet(@RequestBody PredmetDto predmet) {
		if (predmet.getNaziv() == null) {
			return new ResponseEntity("Naziv nije unet.", HttpStatus.BAD_REQUEST);
		}
		if (predmet.getFondCasova() == null) {
			return new ResponseEntity("Fond casova nije unet.", HttpStatus.BAD_REQUEST);
		}
		return predmetService.dodaj(predmet);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dodaj-predaje")
	public ResponseEntity dodajPredaje(@RequestBody PredajeDto predaje) {
		if (predaje.getIdNastavnik() == null) {
			return new ResponseEntity("Nastavnik nije odabran.", HttpStatus.BAD_REQUEST);
		}
		if (predaje.getIdPredmet() == null) {
			return new ResponseEntity("Predmet nije odabran.", HttpStatus.BAD_REQUEST);
		}
		if (predaje.getIdGrupa() == null) {
			return new ResponseEntity("Grupa nije odabrana.", HttpStatus.OK);
		}
		return predmetService.dodajPredaje(predaje);
	}
	
	 @RequestMapping (method = RequestMethod.GET)
	    public ResponseEntity predmeti() {
	        return predmetService.predmeti();
	    }

	    @RequestMapping (method = RequestMethod.GET, value = "/predmet/{id}")
	    public ResponseEntity prikaziPredmet(@PathVariable int id) {
	        return predmetService.pronadjiPredmet(id);
	    }

	    @RequestMapping (method = RequestMethod.PUT, value = "/predmet/{id}")
	    public ResponseEntity izmeni(@PathVariable int id, @RequestBody PredmetDto predmet) {
	        if (predmet.getNaziv() == null) {
	            return new ResponseEntity("Naziv nije unet.", HttpStatus.BAD_REQUEST);
	        }
	        if (predmet.getFondCasova() == null) {
	            return new ResponseEntity("Fond casova nije unet.", HttpStatus.BAD_REQUEST);
	        }
	        return predmetService.izmeniPredmet(id, predmet);
	    }

	    @RequestMapping (method = RequestMethod.DELETE, value = "/predmet/{id}")
	    public ResponseEntity izbrisi(@PathVariable int id) {
	        return predmetService.izbrisiPredmet(id);
	    }
}
