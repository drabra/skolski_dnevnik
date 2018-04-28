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
/*@NamedQuery(name="Razred.findAll", query="SELECT r FROM Razred r")*/
public class Razred {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_razred", unique=true, nullable=false)
	private Integer idRazred;
	
	@Column(length=20)
	private String vrednost;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "razred")
	private List<Grupa> grupas;
	
	public Integer getIdRazred() {
		return idRazred;
	}
	public void setIdRazred(Integer idRazred) {
		this.idRazred = idRazred;
	}
	public String getVrednost() {
		return vrednost;
	}
	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	public Razred(Integer idRazred, String vrednost) {
		super();
		this.idRazred = idRazred;
		this.vrednost = vrednost;
	}
	public Razred() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
