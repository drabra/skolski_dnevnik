package com.iktpreobuka.skolskidnevnik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.skolskidnevnik.dto.RegistracijaDto;
import com.iktpreobuka.skolskidnevnik.service.RegistracijaService;

@RestController
@RequestMapping(path = "/registracija")
public class RegistracijaController {

	@Autowired
	private RegistracijaService registracijaService;

	@RequestMapping(method = RequestMethod.POST, value = "/registruj")
	public ResponseEntity registruj(@RequestBody RegistracijaDto registracija) {
		return registracijaService.registruj(registracija);
	}

}
