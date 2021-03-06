package com.iktpreobuka.skolskidnevnik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iktpreobuka.skolskidnevnik.dto.PredajeDto;
import com.iktpreobuka.skolskidnevnik.dto.PredmetDto;
import com.iktpreobuka.skolskidnevnik.entities.Grupa;
import com.iktpreobuka.skolskidnevnik.entities.Nastavnik;
import com.iktpreobuka.skolskidnevnik.entities.Predaje;
import com.iktpreobuka.skolskidnevnik.entities.Predmet;
import com.iktpreobuka.skolskidnevnik.repositories.GrupaRepository;
import com.iktpreobuka.skolskidnevnik.repositories.NastavnikRepository;
import com.iktpreobuka.skolskidnevnik.repositories.PredajeRepository;
import com.iktpreobuka.skolskidnevnik.repositories.PredmetRepository;

@Service
public class PredmetServiceImpl  {

	 @Autowired
	    private PredajeRepository predajeRepository;

	    @Autowired
	    private NastavnikRepository nastavnikRepository;

	    @Autowired
	    private PredmetRepository predmetRepository;

	    @Autowired
	    private GrupaRepository grupaRepository;

	    /*@Override*/
	    public ResponseEntity<List<Predaje>> nadjiNastavnikovePredmete(int idNastavnik, boolean izTekuceSkolskeGodine) {
	        Nastavnik nastavnik = nastavnikRepository.findOne(idNastavnik);
	        if (nastavnik == null) {
	            return new ResponseEntity("Nastavnik sa datim ID-jem ne postoji.", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity<>(predajeRepository.findAllByNastavnikAndTekucaGodina(idNastavnik, izTekuceSkolskeGodine), HttpStatus.OK);
	    }

	   /* @Override*/
	    public ResponseEntity<Predmet> dodaj(PredmetDto predmetDto) {
	        Predmet predmet = new Predmet();
	        predmet.setFondCasova(predmetDto.getFondCasova());
	        predmet.setNaziv(predmetDto.getNaziv());
	        return new ResponseEntity(predmetRepository.save(predmet), HttpStatus.OK);
	    }

	   /* @Override*/
	    public ResponseEntity<Predaje> dodajPredaje(PredajeDto predajeDto) {
	        Nastavnik nastavnik = nastavnikRepository.findOne(predajeDto.getIdNastavnik());
	        if (nastavnik == null) {
	            return new ResponseEntity("Nastavnik nije pronadjen.", HttpStatus.BAD_REQUEST);
	        }
	        Grupa grupa = grupaRepository.findOne(predajeDto.getIdGrupa());
	        if (grupa == null) {
	            return new ResponseEntity("Grupa nije pronadjena.", HttpStatus.BAD_REQUEST);
	        }
	        Predmet predmet = predmetRepository.findOne(predajeDto.getIdPredmet());
	        if (predmet == null) {
	            return new ResponseEntity("Predmet nije pronadjen.", HttpStatus.BAD_REQUEST);
	        }
	        Predaje predaje = new Predaje();
	        predaje.setGrupa(grupa);
	        predaje.setNastavnik(nastavnik);
	        predaje.setPredmet(predmet);
	        return new ResponseEntity(predajeRepository.save(predaje), HttpStatus.OK);
	    }

	   /* @Override*/
	    public ResponseEntity<List<Predmet>> predmeti() {
	        return new ResponseEntity(predmetRepository.findAll(), HttpStatus.OK);
	    }

	   /* @Override*/
	    public ResponseEntity<Predmet> pronadjiPredmet(int id) {
	        Predmet predmet;
	        predmet = predmetRepository.findOne(id);
	        if (predmet == null) {
	            return new ResponseEntity("Nije pronadjen odabrani predmet.", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(predmet, HttpStatus.OK);
	    }

	    /*@Override*/
	    public ResponseEntity<Predmet> izmeniPredmet(int id, PredmetDto predmetDto) {
	        Predmet predmet;
	        predmet = predmetRepository.findOne(id);
	        if (predmet == null) {
	            return new ResponseEntity("Nije pronadjen odabrani predmet.", HttpStatus.BAD_REQUEST);
	        }
	        predmet.setNaziv(predmetDto.getNaziv());
	        predmet.setFondCasova(predmetDto.getFondCasova());
	        return new ResponseEntity(predmetRepository.save(predmet), HttpStatus.OK);
	    }

	    /*@Override*/
	    public ResponseEntity<Predmet> izbrisiPredmet(int id) {
	        Predmet predmet;
	        predmet = predmetRepository.findOne(id);
	        if (predmet == null) {
	            return new ResponseEntity("Nije pronadjen odabrani predmet.", HttpStatus.BAD_REQUEST);
	        }
	        predmetRepository.delete(id);
	        return new ResponseEntity(predmet, HttpStatus.OK);
	    }
}