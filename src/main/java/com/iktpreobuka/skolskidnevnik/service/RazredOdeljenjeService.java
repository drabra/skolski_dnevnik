package com.iktpreobuka.skolskidnevnik.service;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.skolskidnevnik.dto.GrupaDto;
import com.iktpreobuka.skolskidnevnik.dto.OdeljenjeDto;
import com.iktpreobuka.skolskidnevnik.dto.RazredDto;
import com.iktpreobuka.skolskidnevnik.dto.SkolaskaGodinaDto;
import com.iktpreobuka.skolskidnevnik.dto.UcenikGrupaDto;
import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Odeljenje;
import com.iktpreobuka.skolskidnevnik.entities.Razred;
import com.iktpreobuka.skolskidnevnik.entities.SkolskaGodina;

public interface RazredOdeljenjeService {
	ResponseEntity<Razred> dodajRazred(RazredDto razredDto);
	ResponseEntity<Odeljenje> dodajOdeljenje(OdeljenjeDto odeljenjeDto);
	ResponseEntity<Grupa> dodajGrupu(GrupaDto grupaDto);
	ResponseEntity<SkolskaGodina> dodajSkolskuGodinu(SkolaskaGodinaDto skolaskaGodinaDto);
	ResponseEntity<Grupa> dodajUcenikaUGrupu(UcenikGrupaDto ucenikGrupaGto);

}
