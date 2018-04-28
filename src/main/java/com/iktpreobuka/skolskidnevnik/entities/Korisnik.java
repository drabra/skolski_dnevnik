package com.iktpreobuka.skolskidnevnik.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/*@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")*/
public class Korisnik {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_korisnik", unique=true, nullable=false)
	private Integer idKorisnik;
	
	@Column(name="korisnicka_lozinka", length=50)
	private String korisnickaLozinka;
	
	@Column(name="korisnicko_ime", length=50)
	private String korisnickoIme;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Nastavnik> nastavniks;
	

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Roditelj> roditeljs;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Ucenik> uceniks;
	
	     
	public Integer getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(Integer idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	public String getKorisnickaLozinka() {
		return korisnickaLozinka;
	}
	public void setKorisnickaLozinka(String korisnickaLozinka) {
		this.korisnickaLozinka = korisnickaLozinka;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public Korisnik(Integer idKorisnik, String korisnickaLozinka, String korisnickoIme) {
		super();
		this.idKorisnik = idKorisnik;
		this.korisnickaLozinka = korisnickaLozinka;
		this.korisnickoIme = korisnickoIme;
	}
	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Nastavnik> getNastavniks() {
		return nastavniks;
	}
	public void setNastavniks(List<Nastavnik> nastavniks) {
		this.nastavniks = nastavniks;
	}
	public List<Roditelj> getRoditeljs() {
		return roditeljs;
	}
	public void setRoditeljs(List<Roditelj> roditeljs) {
		this.roditeljs = roditeljs;
	}
	public List<Ucenik> getUceniks() {
		return uceniks;
	}
	public void setUceniks(List<Ucenik> uceniks) {
		this.uceniks = uceniks;
	}
	public Korisnik(Integer idKorisnik, String korisnickaLozinka, String korisnickoIme, List<Nastavnik> nastavniks,
			List<Roditelj> roditeljs, List<Ucenik> uceniks) {
		super();
		this.idKorisnik = idKorisnik;
		this.korisnickaLozinka = korisnickaLozinka;
		this.korisnickoIme = korisnickoIme;
		this.nastavniks = nastavniks;
		this.roditeljs = roditeljs;
		this.uceniks = uceniks;
	}

}
