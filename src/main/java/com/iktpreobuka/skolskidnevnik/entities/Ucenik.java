package com.iktpreobuka.skolskidnevnik.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/*@NamedQuery(name = "Ucenik.findAll", query="SELECT u FROM Ucenik u")*/
public class Ucenik {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable = false)
	private int idUcenik;
	
	@Column(length=50)
	private String ime;
	
	@Column(length=50)
	private String prezime;
	
	@ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(name="grupa_has_ucenik", joinColumns={@JoinColumn(name="ucenik_id_ucenik", nullable=false)}, inverseJoinColumns={@JoinColumn(name="grupa_id_grupa", nullable=false)})
	private List<Grupa> grupas;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="ucenik")
	private List<Ocena> ocenas;
	
	@ManyToOne
	@JoinColumn(name="korisnik_id_korisnik", nullable=false)
	private Korisnik korisnik;
	
	@ManyToOne
	@JoinColumn(name="roditelj_id_roditelj", nullable=false)
	private Roditelj roditelj;
	
	public int getIdUcenik() {
		return idUcenik;
	}
	public void setIdUcenik(int idUcenik) {
		this.idUcenik = idUcenik;
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
	public Ucenik(int idUcenik, String ime, String prezime) {
		super();
		this.idUcenik = idUcenik;
		this.ime = ime;
		this.prezime = prezime;
	}
	public Ucenik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Grupa> getGrupas() {
		return grupas;
	}
	public void setGrupas(List<Grupa> grupas) {
		this.grupas = grupas;
	}
	public List<Ocena> getOcenas() {
		return ocenas;
	}
	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Roditelj getRoditelj() {
		return roditelj;
	}
	public void setRoditelj(Roditelj roditelj) {
		this.roditelj = roditelj;
	}
	public Ucenik(int idUcenik, String ime, String prezime, List<Grupa> grupas, List<Ocena> ocenas, Korisnik korisnik,
			Roditelj roditelj) {
		super();
		this.idUcenik = idUcenik;
		this.ime = ime;
		this.prezime = prezime;
		this.grupas = grupas;
		this.ocenas = ocenas;
		this.korisnik = korisnik;
		this.roditelj = roditelj;
	}
	
	

}
