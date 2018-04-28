package com.iktpreobuka.skolskidnevnik.dto;

public class GrupaDto {
	
	private Integer idSkolskaGodina;
	private Integer idRazred;
	private Integer idOdeljenje;
	public GrupaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GrupaDto(Integer idSkolskaGodina, Integer idRazred, Integer idOdeljenje) {
		super();
		this.idSkolskaGodina = idSkolskaGodina;
		this.idRazred = idRazred;
		this.idOdeljenje = idOdeljenje;
	}
	public Integer getIdSkolskaGodina() {
		return idSkolskaGodina;
	}
	public void setIdSkolskaGodina(Integer idSkolskaGodina) {
		this.idSkolskaGodina = idSkolskaGodina;
	}
	public Integer getIdRazred() {
		return idRazred;
	}
	public void setIdRazred(Integer idRazred) {
		this.idRazred = idRazred;
	}
	public Integer getIdOdeljenje() {
		return idOdeljenje;
	}
	public void setIdOdeljenje(Integer idOdeljenje) {
		this.idOdeljenje = idOdeljenje;
	}

}
