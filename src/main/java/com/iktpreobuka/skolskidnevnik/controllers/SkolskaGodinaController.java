package com.iktpreobuka.skolskidnevnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.skolskidnevnik.dto.SkolaskaGodinaDto;
import com.iktpreobuka.skolskidnevnik.service.RazredOdeljenjeService;

@RestController
@RequestMapping("/skolska_godina")
public class SkolskaGodinaController {
	
	@Autowired
	private RazredOdeljenjeService razredOdeljenjeService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodaj")
	public ResponseEntity dodajSkolskuGodinu(@RequestBody SkolaskaGodinaDto skolaskaGodinaDto) {
		if (skolaskaGodinaDto.getVrednost()== null) {
			return new ResponseEntity("Vrednost nije uneta", HttpStatus.BAD_REQUEST);
		}
		if (skolaskaGodinaDto.getTrenutna() == null) {
			return new ResponseEntity("Nije odabrano da li je trenutna.", HttpStatus.BAD_REQUEST);
		}
		return razredOdeljenjeService.dodajSkolskuGodinu(skolaskaGodinaDto);
	}

}
