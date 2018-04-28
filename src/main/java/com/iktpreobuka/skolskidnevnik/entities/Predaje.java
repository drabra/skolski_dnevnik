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
/*@NamedQuery(name="Predaje.findAll", query="SELECT p FROM Predaje p")*/
public class Predaje {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_predaje", unique=true, nullable=false)
	private Integer idPredaje;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="predaje")
	private List<Ocena> ocenas;
	
	@ManyToOne
	@JoinColumn(name="nastavnik_id_nastavnik", nullable=false)
	private Nastavnik nastavnik;
	
	@ManyToOne
	@JoinColumn(name="predmet_id_predmet", nullable=false)
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name="grupa_id_grupa", nullable = false)
	private Grupa grupa;

	public Integer getIdPredaje() {
		return idPredaje;
	}

	public void setIdPredaje(Integer idPredaje) {
		this.idPredaje = idPredaje;
	}

	public List<Ocena> getOcenas() {
		return ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Grupa getGrupa() {
		return grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public Predaje(Integer idPredaje, List<Ocena> ocenas, Nastavnik nastavnik, Predmet predmet, Grupa grupa) {
		super();
		this.idPredaje = idPredaje;
		this.ocenas = ocenas;
		this.nastavnik = nastavnik;
		this.predmet = predmet;
		this.grupa = grupa;
	}

	public Predaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

