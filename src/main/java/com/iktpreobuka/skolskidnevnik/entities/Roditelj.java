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
/*@NamedQuery(name="Roditelj.findAll", query="SELECT r FROM Roditlej r")*/
public class Roditelj {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_roditelj;
	
	@Column(length=50)
	private String ime;
	
	@Column(length=50)
	private String prezime;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="roditelj")
	List<Ucenik> uceniks;
	
	@ManyToOne
	@JoinColumn(name="korisnik_id_korisnik", nullable=false)
	private Korisnik korisnik;
	
	public Integer getId_roditelj() {
		return id_roditelj;
	}
	
	public void setId_roditelj(Integer id_roditelj) {
		this.id_roditelj = id_roditelj;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getRezime() {
		return prezime;
	}
	public void setRezime(String prezime) {
		this.prezime = prezime;
	}
	public Roditelj(Integer id_roditelj, String ime, String prezime) {
		super();
		this.id_roditelj = id_roditelj;
		this.ime = ime;
		this.prezime = prezime;
	}
	public Roditelj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Ucenik> getUceniks() {
		return uceniks;
	}

	public void setUceniks(List<Ucenik> uceniks) {
		this.uceniks = uceniks;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Roditelj(Integer id_roditelj, String ime, String prezime, List<Ucenik> uceniks, Korisnik korisnik) {
		super();
		this.id_roditelj = id_roditelj;
		this.ime = ime;
		this.prezime = prezime;
		this.uceniks = uceniks;
		this.korisnik = korisnik;
	}

}
