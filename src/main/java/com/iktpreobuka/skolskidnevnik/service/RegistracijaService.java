package com.iktpreobuka.skolskidnevnik.service;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.skolskidnevnik.dto.RegistracijaDto;

public interface RegistracijaService {
	ResponseEntity registruj(RegistracijaDto registracija);

}
