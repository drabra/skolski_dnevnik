package com.iktpreobuka.skolskidnevnik.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/*@NamedQuery(name="Nastavnik.findAll", query="SELECT n FROM Nastavnik n")*/
public class Nastavnik {
	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nastavnik", unique = true, nullable = false)
	private Integer idNastavnik;

	@Column(length = 50)
	private String ime;

	@Column(length = 50)
	private String prezime;

	@ManyToOne
	@JoinColumn(name = "korisnik_id_korisnik", nullable = false)
	private Korisnik korisnik;

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "nastavnik")
	private List<Predaje> predajes;

	public Integer getIdNastavnik() {
		return idNastavnik;
	}

	public void setIdNastavnik(Integer idNastavnik) {
		this.idNastavnik = idNastavnik;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Nastavnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Predaje> getPredajes() {
		return predajes;
	}

	public void setPredajes(List<Predaje> predajes) {
		this.predajes = predajes;
	}

	public Nastavnik(Integer idNastavnik, String ime, String prezime, Korisnik korisnik, List<Predaje> predajes) {
		super();
		this.idNastavnik = idNastavnik;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnik = korisnik;
		this.predajes = predajes;
	}

}
