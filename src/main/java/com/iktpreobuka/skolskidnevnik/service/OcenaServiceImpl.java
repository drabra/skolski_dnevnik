package com.iktpreobuka.skolskidnevnik.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iktpreobuka.skolskidnevnik.dto.OcenaDto;
import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Nastavnik;
import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.entities.Predaje;
import com.iktpreobuka.skolskidnevnik.entities.Predmet;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;
import com.iktpreobuka.skolskidnevnik.repositories.GrupaRepository;
import com.iktpreobuka.skolskidnevnik.repositories.NastavnikRepository;
import com.iktpreobuka.skolskidnevnik.repositories.OcenaRepository;
import com.iktpreobuka.skolskidnevnik.repositories.PredajeRepository;
import com.iktpreobuka.skolskidnevnik.repositories.PredmetRepository;
import com.iktpreobuka.skolskidnevnik.repositories.UcenikRepository;

@Service
public class OcenaServiceImpl implements OcenaService {

	private static final Integer PRVO_POLUGODISTE = 1;
	private static final Integer DRUGO_POLUGODISTE = 2;

	@Autowired
	private UcenikRepository ucenikRepository;

	@Autowired
	private NastavnikRepository nastavnikRepository;
	
	@Autowired
	private PredmetRepository predmetRepository;


	@Autowired
	private GrupaRepository grupaRepository;

	@Autowired
	private PredajeRepository predajeRepository;

	@Autowired
	private OcenaRepository ocenaRepository;

	@Override
	@Transactional
	public ResponseEntity<Ocena> oceni(OcenaDto ocenaDto) {
		Ucenik ucenik = ucenikRepository.findOne(ocenaDto.getIdUcenik());
		if (ucenik == null) {
			return new ResponseEntity("Ne postoji ucenik sa datim id-jem", HttpStatus.BAD_REQUEST);
		}
		
		Nastavnik nastavnik = nastavnikRepository.findOne(ocenaDto.getIdNastavnik());
		if (nastavnik == null) {
			return new ResponseEntity("Ne postoji nastavnik sa datim id-jem", HttpStatus.BAD_REQUEST);
		}
		
		Predmet predmet = predmetRepository.findOne(ocenaDto.getIdPredmet());
		if (predmet == null) {
			return new ResponseEntity("Ne postoji predmet sa datim id-jem", HttpStatus.BAD_REQUEST);
		}
		
		Grupa grupa = grupaRepository.findOne(ocenaDto.getIdGrupa());
		if (grupa == null) {
			return new ResponseEntity("Ne postoji grupa sa datim id-jem", HttpStatus.BAD_REQUEST);
		}
        else 
        	if (!ucenikPripadaGrupi(ucenik.getGrupas(), grupa.getIdGrupa())) {
			     return new ResponseEntity("Ucenik ne pripada odabranoj grupi.", HttpStatus.BAD_REQUEST);
		}
        	else
        		if (!grupa.getSkolskaGodina().getTrenutna()) {
			return new ResponseEntity("Odabrana je grupa koja nije u tekucoj skolskoj godini", HttpStatus.BAD_REQUEST);
		}
		
		Predaje predaje = predajeRepository.findByNastavnikAndGrupaAndPredmet(nastavnik, grupa, predmet);
		if (predaje == null) {
			return new ResponseEntity("Greska pri dodavanju ocene, proverite parametre", HttpStatus.BAD_REQUEST);
		}
		
		if (ocenaDto.getOcena() < 1 || ocenaDto.getOcena() > 5) {
			
			return new ResponseEntity("Ocena mora biti izmedju 1 i 5", HttpStatus.BAD_REQUEST);
		}
		
		if (ocenaDto.getPolugodiste() != PRVO_POLUGODISTE && ocenaDto.getPolugodiste() != DRUGO_POLUGODISTE) {
			return new ResponseEntity("Polugodiste mora biti 1 ili 2", HttpStatus.BAD_REQUEST);
		}
		
		if (ocenaDto.getZakljucnaOcena()) {
			List<Ocena> ocene = ocenaRepository.findAllByOrderByVremeOcenjivanja(ucenik);
			
		if (ocene != null) {
				for (Ocena ocena : ocene) {
					if (ocena.getPredaje().getGrupa().getSkolskaGodina().getTrenutna()
							&& ocena.getPolugodiste() == ocenaDto.getPolugodiste() && ocena.getZakljucnaOcena()) {
						return new ResponseEntity("Vec postoji zakljucena ocena", HttpStatus.BAD_REQUEST);
					}
				}
				
				if (ocenaDto.getPolugodiste() == DRUGO_POLUGODISTE && !zakljucenoPrvoPolugodiste(ocene)) {
					return new ResponseEntity("Ne postoji zakljuceno prvo polugodiste", HttpStatus.BAD_REQUEST);
				}
			}
		}

		Ocena ocenaZaDodavanje = new Ocena();
		ocenaZaDodavanje.setUcenik(ucenik);
		ocenaZaDodavanje.setVrednost(ocenaDto.getOcena());
		ocenaZaDodavanje.setPolugodiste(ocenaDto.getPolugodiste());
		ocenaZaDodavanje.setZakljucnaOcena(ocenaDto.getZakljucnaOcena());
		Date date = new Date(0);
		ocenaZaDodavanje.setVremeOcenjivanja(new Timestamp(date.getTime()));
		ocenaZaDodavanje.setPredaje(predaje);
		Ocena dodataOcena = ocenaRepository.save(ocenaZaDodavanje);
		if (dodataOcena == null) {
			return new ResponseEntity("Greska prilikom dodavanja ocene u bazu", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(dodataOcena, HttpStatus.OK);
	}

	private boolean zakljucenoPrvoPolugodiste(List<Ocena> ocene) {
		boolean zakljuceno = false;
		for (Ocena ocena : ocene) {
			if (ocena.getPolugodiste() == PRVO_POLUGODISTE
					&& ocena.getPredaje().getGrupa().getSkolskaGodina().getTrenutna() && ocena.getZakljucnaOcena()) {
				zakljuceno = true;
				break;
			}
		}
		return zakljuceno;
	}

	private boolean ucenikPripadaGrupi(List<Grupa> ucenikGrupe, Integer grupa) {
		boolean pripada = false;
		for (Grupa gr : ucenikGrupe) {
			int tekuca = gr.getIdGrupa();
			if (tekuca == grupa) {
				pripada = true;
				break;
			}
		}
		return pripada;

	}
}


