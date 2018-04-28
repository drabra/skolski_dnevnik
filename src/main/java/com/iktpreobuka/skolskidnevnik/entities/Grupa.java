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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/*@NamedQuery(name="Grupa.findAll", query="SELECT g FROM Grupa g")*/
public class Grupa {
	private static final long SerialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_grupa", unique=true, nullable=false)
	private Integer idGrupa;
	
	@ManyToOne
	@JoinColumn(name="skolska_godina_id_dragana_god", nullable=false)
	private SkolskaGodina skolskaGodina;
	
	
	@ManyToOne
	@JoinColumn(name="razred_id_razred", nullable=false)
	private Razred razred;
	
	@ManyToOne
	@JoinColumn(name="odeljenje_id_odeljenje", nullable=false)
	private Odeljenje odeljenje;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "grupa")
	private List<Predaje> predajes;
	
	
	@ManyToMany(mappedBy="grupas", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Ucenik> uceniks;
	
	public Integer getIdGrupa() {
		return idGrupa;
	} 
	public void setIdGrupa(Integer idGrupa) {
		this.idGrupa = idGrupa;
	}
	
	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	public Razred getRazred() {
		return razred;
	}
	public void setRazred(Razred razred) {
		this.razred = razred;
	}
	public Odeljenje getOdeljenje() {
		return odeljenje;
	}
	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}
	public Grupa(Integer idGrupa, SkolskaGodina skolskaGodina, Razred razred, Odeljenje odeljenje) {
		super();
		this.idGrupa = idGrupa;
		this.skolskaGodina = skolskaGodina;
		this.razred = razred;
		this.odeljenje = odeljenje;
	} 
	public Grupa() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
