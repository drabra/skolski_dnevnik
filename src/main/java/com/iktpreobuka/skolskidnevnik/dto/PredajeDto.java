package com.iktpreobuka.skolskidnevnik.dto;

public class PredajeDto {
	
	private Integer idNastavnik;
	private Integer idPredmet;
	private Integer idGrupa;
	public PredajeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PredajeDto(Integer idNastavnik, Integer idPredmet, Integer idGrupa) {
		super();
		this.idNastavnik = idNastavnik;
		this.idPredmet = idPredmet;
		this.idGrupa = idGrupa;
	}
	public Integer getIdNastavnik() {
		return idNastavnik;
	}
	public void setIdNastavnik(Integer idNastavnik) {
		this.idNastavnik = idNastavnik;
	}
	public Integer getIdPredmet() {
		return idPredmet;
	}
	public void setIdPredmet(Integer idPredmet) {
		this.idPredmet = idPredmet;
	}
	public Integer getIdGrupa() {
		return idGrupa;
	}
	public void setIdGrupa(Integer idGrupa) {
		this.idGrupa = idGrupa;
	}

}
