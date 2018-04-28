package com.iktpreobuka.skolskidnevnik.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
/*@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")*/
public class Ocena {
	private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ocene", unique=true, nullable=false)
	private Integer idOcena;
	
	private Integer polugodiste;
	
	private Integer vrednost;
	@Column(name="vreme_ocenjivanja")
	private Timestamp vremeOcenjivanja;
	@Column(name="zakljuna_ocena")
	private boolean zakljucnaOcena;
	@ManyToOne
	@JoinColumn(name="ucenik_id_ucenik", nullable=false)
	private Ucenik ucenik;
	@ManyToOne
	@JoinColumn(name="predaje_id_predaje", nullable=false)
	private Predaje predaje;
	
	public Integer getIdOcena() {
		return idOcena;
	}
	public void setIdOcena(Integer idOcena) {
		this.idOcena = idOcena;
	}
	public Integer getPolugodiste() {
		return polugodiste;
	}
	public void setPolugodiste(Integer polugodiste) {
		this.polugodiste = polugodiste;
	}
	public Integer getVrednost() {
		return vrednost;
	}
	public void setVrednost(Integer vrednost) {
		this.vrednost = vrednost;
	}
	public Timestamp getVremeOcenjivanja() {
		return vremeOcenjivanja;
	}
	public void setVremeOcenjivanja(Timestamp vremeOcenjivanja) {
		this.vremeOcenjivanja = vremeOcenjivanja;
	}
	public boolean getZakljucnaOcena() {
		return zakljucnaOcena;
	}
	public void setZakljucnaOcena(boolean zakljucnaOcena) {
		this.zakljucnaOcena = zakljucnaOcena;
	}

	
	public Ocena(Integer idOcena, Integer polugodiste, Integer vrednost, Timestamp vremeOcenjivanja,
			boolean zakljucnaOcena) {
		super();
		this.idOcena = idOcena;
		this.polugodiste = polugodiste;
		this.vrednost = vrednost;
		this.vremeOcenjivanja = vremeOcenjivanja;
		this.zakljucnaOcena = zakljucnaOcena;
		this.ucenik = ucenik;
	    this.predaje = predaje;
	}
	public Ocena() { 
	
		super();
		// TODO Auto-generated constructor stub
	}
	public Ucenik getUcenik() {
		return ucenik;
	}
	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	public Predaje getPredaje() {
		return predaje;
	}
	public void setPredaje(Predaje predaje) {
		this.predaje = predaje;
	}
}  
