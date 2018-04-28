package com.iktpreobuka.skolskidnevnik.dto;

public class UcenikGrupaDto {
	private Integer idUcenik;
	private Integer idGrupa;
	public UcenikGrupaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UcenikGrupaDto(Integer idUcenik, Integer idGrupa) {
		super();
		this.idUcenik = idUcenik;
		this.idGrupa = idGrupa;
	}
	public Integer getIdUcenik() {
		return idUcenik;
	}
	public void setIdUcenik(Integer idUcenik) {
		this.idUcenik = idUcenik;
	}
	public Integer getIdGrupa() {
		return idGrupa;
	}
	public void setIdGrupa(Integer idGrupa) {
		this.idGrupa = idGrupa;
	}

}
