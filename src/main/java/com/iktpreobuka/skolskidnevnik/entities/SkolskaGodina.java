package com.iktpreobuka.skolskidnevnik.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="skolska_godina")
/*@NamedQuery(name="SkolskaGodina.findAll", query="SELECT s FROM SkolskaGodina s")*/
public class SkolskaGodina {
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_skolska_godina", unique=true, nullable=false)
	private Integer idSkolskaGodina;
	private boolean trenutna;
	
	@Column(length=20)
	private String vrednost;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "skolskaGodina")
	private List<Grupa> grupas;

	public Integer getIdSkolskaGodina() {
		return idSkolskaGodina;
	}

	public void setIdSkolskaGodina(Integer idSkolskaGodina) {
		this.idSkolskaGodina = idSkolskaGodina;
	}

	public boolean getTrenutna() {
		return trenutna;
	}

	public void setTrenutna(boolean trenutna) {
		this.trenutna = trenutna;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}

	public SkolskaGodina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkolskaGodina(Integer idSkolskaGodina, boolean trenutna, String vrednost) {
		super();
		this.idSkolskaGodina = idSkolskaGodina;
		this.trenutna = trenutna;
		this.vrednost = vrednost;
	}
	

}
