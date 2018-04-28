package com.iktpreobuka.skolskidnevnik.entities;

import java.io.Serializable;

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
/*@NamedQuery(name="Predmet.findAll", query="SELECT p FROM Predmet p")*/
public class Predmet implements Serializable {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_predmet", unique=true, nullable=false)
	private Integer idPredmet;
	
	@Column(name="fond_casova")
	private Integer fondCasova;
	
	@Column(length=50)
	private String naziv;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy ="predmet")
	
	public Integer getIdPredmet() {
		return idPredmet;
	}
	public void setIdPredmet(Integer idPredmet) {
		this.idPredmet = idPredmet;
	}
	public Integer getFondCasova() {
		return fondCasova;
	}
	public void setFondCasova(Integer fondCasova) {
		this.fondCasova = fondCasova;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Predmet(Integer idPredmet, Integer fondCasova, String naziv) {
		super();
		this.idPredmet = idPredmet;
		this.fondCasova = fondCasova;
		this.naziv = naziv;
	}
	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

}
