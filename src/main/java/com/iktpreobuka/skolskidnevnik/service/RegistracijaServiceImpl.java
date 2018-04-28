package com.iktpreobuka.skolskidnevnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iktpreobuka.skolskidnevnik.dto.RegistracijaDto;
import com.iktpreobuka.skolskidnevnik.entities.Korisnik;
import com.iktpreobuka.skolskidnevnik.entities.Nastavnik;
import com.iktpreobuka.skolskidnevnik.entities.Roditelj;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;
import com.iktpreobuka.skolskidnevnik.repositories.KorisnikRepository;
import com.iktpreobuka.skolskidnevnik.repositories.NastavnikRepository;
import com.iktpreobuka.skolskidnevnik.repositories.RoditeljRepository;
import com.iktpreobuka.skolskidnevnik.repositories.UcenikRepository;

@Service
public class RegistracijaServiceImpl implements RegistracijaService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private UcenikRepository ucenikRepository;
	
	@Autowired
	private RoditeljRepository roditeljRepositroy;
	
	@Autowired
	private NastavnikRepository nastavnikRepository;

	@Override
	@Transactional
	public ResponseEntity registruj(RegistracijaDto registracija) {
		if (korisnikRepository.findByKorisnickoIme(registracija.getKorisnickalozinka()) != null) {
			return new ResponseEntity("Korisnik postoji", HttpStatus.BAD_REQUEST);
		}
		Korisnik k = new Korisnik();
		k.setKorisnickoIme(registracija.getKorisnickoIme());
		k.setKorisnickaLozinka(registracija.getKorisnickalozinka());
		if(registracija.getUloga() == 1) {
			Roditelj roditelj = roditeljRepositroy.findOne(registracija.getImeRoditelja());
			if (roditelj == null) {
				return new ResponseEntity("Los zahtev", HttpStatus.BAD_REQUEST);
			}
			Ucenik u = new Ucenik();
			u.setIme(registracija.getIme());
			u.setPrezime(registracija.getPrezime());
			Korisnik kreiraniKorisnik = korisnikRepository.save(k);
			u.setKorisnik(kreiraniKorisnik);
			u.setRoditelj(roditelj);
			ucenikRepository.save(u);
			return new ResponseEntity("Uspesno", HttpStatus.OK);
		}

		
			
		       else if (registracija.getUloga() == 2) {
			Nastavnik n = new Nastavnik();
			n.setIme(registracija.getIme());
			n.setPrezime(registracija.getPrezime());
			Korisnik kreiraniKorisnik = korisnikRepository.save(k);
			n.setKorisnik(kreiraniKorisnik);
			nastavnikRepository.save(n);
			return new ResponseEntity("Uspesno", HttpStatus.OK);
		}
		else if (registracija.getUloga() == 3) {
			Roditelj r = new Roditelj();
			r.setIme(registracija.getIme());
			r.setRezime(registracija.getPrezime());
			Korisnik kreiraniKorisnik = korisnikRepository.save(k);
			r.setKorisnik(kreiraniKorisnik);
			roditeljRepositroy.save(r);
			return new ResponseEntity("Uspesno", HttpStatus.OK);
		}
		else {
			return new ResponseEntity("Los zahtev", HttpStatus.BAD_REQUEST);
		}
	}

}
