package com.iktpreobuka.skolskidnevnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.skolskidnevnik.dto.GrupaDto;
import com.iktpreobuka.skolskidnevnik.dto.OdeljenjeDto;
import com.iktpreobuka.skolskidnevnik.dto.RazredDto;
import com.iktpreobuka.skolskidnevnik.dto.UcenikGrupaDto;
import com.iktpreobuka.skolskidnevnik.service.RazredOdeljenjeService;

@RestController
@RequestMapping("razred-odeljenje")
public class RazredOdeljenjeController {

	@Autowired
	RazredOdeljenjeService razredOdeljenjeService;

	@RequestMapping(method = RequestMethod.POST, value = "/dodaj-razred")
	public ResponseEntity dodajRazred(@RequestBody RazredDto razredDto) {
		if (razredDto.getNaziv() == null) {
			return new ResponseEntity("Naziv nije unet", HttpStatus.BAD_REQUEST);
		}
		return razredOdeljenjeService.dodajRazred(razredDto);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dodaj-odeljenje")
	public ResponseEntity dodajOdeljenje(@RequestBody OdeljenjeDto odeljenjeDto) {
		if (odeljenjeDto.getNaziv() == null) {
			return new ResponseEntity("Naziv nije unet.", HttpStatus.BAD_REQUEST);
		}
		return razredOdeljenjeService.dodajOdeljenje(odeljenjeDto);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dodaj-grupu")
	public ResponseEntity dodajGrupu(@RequestBody GrupaDto grupaDto) {
		if (grupaDto.getIdOdeljenje() == null) {
			return new ResponseEntity("Odeljenje nije odabrano.", HttpStatus.BAD_REQUEST);
		}
		if (grupaDto.getIdSkolskaGodina() == null) {
			return new ResponseEntity("Skolskagodjan nije odabrana.", HttpStatus.BAD_REQUEST);
		}
		return razredOdeljenjeService.dodajGrupu(grupaDto);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/dodaj-ucenika-u-grupu")
	public ResponseEntity dodajUcenikaUGrupu(@RequestBody UcenikGrupaDto ucenikGrupaDto) {
		if (ucenikGrupaDto.getIdGrupa() == null) {
			return new ResponseEntity("Grupa nije odabrana.", HttpStatus.BAD_REQUEST);
		}
		if (ucenikGrupaDto.getIdUcenik() == null) {
			return new ResponseEntity("Ucenik nije odabran", HttpStatus.BAD_REQUEST);
		}
		return razredOdeljenjeService.dodajUcenikaUGrupu(ucenikGrupaDto);
	}

}
