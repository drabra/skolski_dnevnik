package com.iktpreobuka.skolskidnevnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iktpreobuka.skolskidnevnik.dto.GrupaDto;
import com.iktpreobuka.skolskidnevnik.dto.OdeljenjeDto;
import com.iktpreobuka.skolskidnevnik.dto.RazredDto;
import com.iktpreobuka.skolskidnevnik.dto.SkolaskaGodinaDto;
import com.iktpreobuka.skolskidnevnik.dto.UcenikGrupaDto;
import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Odeljenje;
import com.iktpreobuka.skolskidnevnik.entities.Razred;
import com.iktpreobuka.skolskidnevnik.entities.SkolskaGodina;
import com.iktpreobuka.skolskidnevnik.repositories.GrupaRepository;
import com.iktpreobuka.skolskidnevnik.repositories.OdeljenjeRepository;
import com.iktpreobuka.skolskidnevnik.repositories.RazredRepository;
import com.iktpreobuka.skolskidnevnik.repositories.SkolskaGodinaRepository;
import com.iktpreobuka.skolskidnevnik.repositories.UcenikRepository;

@Service
public class RazredOdeljenjeServiceImpl implements RazredOdeljenjeService {
	
	@Autowired
	private RazredRepository razredRepository;
	
	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@Autowired
	private SkolskaGodinaRepository skolskaGodinaRepository;
	
	@Autowired
	private UcenikRepository ucenikRepository;
	
	@Override
	@Transactional
	public ResponseEntity<Razred> dodajRazred(RazredDto razredDto) {
		Razred razred = new Razred();
		razred.setVrednost(razredDto.getNaziv());
		return new ResponseEntity<>(razredRepository.save(razred), HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<Odeljenje> dodajOdeljenje(OdeljenjeDto odeljenjeDto) {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setVrednost(odeljenjeDto.getNaziv());
		return new ResponseEntity<>(odeljenjeRepository.save(odeljenje), HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<Grupa> dodajGrupu(GrupaDto grupaDto) {
		Razred razred = razredRepository.findOne(grupaDto.getIdRazred());
		if (razred == null) {
			return new ResponseEntity("Odabrani razred ne psotoji", HttpStatus.BAD_REQUEST);
		}
		Odeljenje odeljenje = odeljenjeRepository.findOne(grupaDto.getIdOdeljenje());
		if (odeljenje == null) {
			return new ResponseEntity("Odabrano odeljenje ne postoji", HttpStatus.BAD_REQUEST);
		}
		SkolskaGodina skolskaGodina = skolskaGodinaRepository.findOne(grupaDto.getIdSkolskaGodina());
		if (skolskaGodina == null) {
			return new ResponseEntity("Odabrana skolska godina ne postoji", HttpStatus.BAD_REQUEST);
		}
		Grupa grupa = new Grupa();
		grupa.setOdeljenje(odeljenje);
		grupa.setRazred(razred);
		grupa.setSkolskaGodina(skolskaGodina);
		Grupa provera = grupaRepository.findByRazredAndOdeljenjeAndSkolskaGodina(razred, odeljenje, skolskaGodina);
		if (provera!= null) {
			return new ResponseEntity("Grupa vec postoji", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(grupaRepository.save(grupa), HttpStatus.OK);
	}
	@Override
	@Transactional
	public ResponseEntity<SkolskaGodina> dodajSkolskuGodinu (SkolaskaGodinaDto skolaskaGodinaDto) {
		SkolskaGodina skolskaGodina = new SkolskaGodina();
		skolskaGodina.setVrednost(skolaskaGodinaDto.getVrednost());
		if(skolaskaGodinaDto.getTrenutna()) {
			SkolskaGodina trenutnaIsTrue = skolskaGodinaRepository.findByTrenutnaIsTrue();
			if (trenutnaIsTrue != null) {
				trenutnaIsTrue.setTrenutna(false);
				skolskaGodinaRepository.save(trenutnaIsTrue);
			}
		}
		skolskaGodina.setTrenutna(skolaskaGodinaDto.getTrenutna());
		return new ResponseEntity<>(skolskaGodinaRepository.save(skolskaGodina), HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<Grupa> dodajUcenikaUGrupu(UcenikGrupaDto ucenikGrupaDto) {
		Grupa grupa = grupaRepository.findOne(ucenikGrupaDto.getIdGrupa());
		if (grupa == null) {
			return new ResponseEntity("Odabrana grupa ne postoji.", HttpStatus.BAD_REQUEST);
		}
	/*	Ucenik ucenik = ucenikRepository.findOne(ucenikGrupaDto.getIdUcenik());
		if (ucenik == null) {
			return new ResponseEntity("Odabrani ucenik ne postoji", HttpStatus.BAD_REQUEST);
		}
		List<Ucenik> ucenici = grupa.getUceniks();
		if (ucenici == null) {
			ucenici = new ArrayList<>();
		}
		ucenici.add(ucenik);
		grupa.setUceniks(ucenici);
		List<Grupa> grupe = ucenik.getGrupas();
		if (grupe == null) {
			grupe = new ArrayList<>();
		}
		grupe.add(grupa);
		grupaRepository.save(grupa);
		return new ResponseEntity("Usepsno.", HttpStatus.OK);
		
	*/
		return null;
			}
		
	}
		
		
	


