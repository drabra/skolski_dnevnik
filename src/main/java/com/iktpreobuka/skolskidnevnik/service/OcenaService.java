package com.iktpreobuka.skolskidnevnik.service;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.skolskidnevnik.dto.OcenaDto;
import com.iktpreobuka.skolskidnevnik.entities.Ocena;

public interface OcenaService {
	ResponseEntity<Ocena> oceni(OcenaDto ocenaDto);

}
