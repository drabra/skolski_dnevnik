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
/*@NamedQuery(name="Odeljenje.findAll", query="SELECT o FROM Odeljenje o")*/
public class Odeljenje {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_odeljenja", unique=true, nullable=false)
	private Integer idOdeljenje;
	
	@Column(length=20)
	private String vrednost;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy="odeljenje")
	private List<Grupa> grupas;
	
	public Integer getIdOdeljenje() {
		return idOdeljenje;
	}
	public void setIdOdeljenje(Integer idOdeljenje) {
		this.idOdeljenje = idOdeljenje;
	}
	public String getVrednost() {
		return vrednost;
	}
	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	public Odeljenje(Integer idOdeljenje, String vrednost) {
		super();
		this.idOdeljenje = idOdeljenje;
		this.vrednost = vrednost;
	}
	public Odeljenje() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
