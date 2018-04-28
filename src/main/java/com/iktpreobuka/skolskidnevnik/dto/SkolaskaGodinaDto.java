package com.iktpreobuka.skolskidnevnik.dto;

public class SkolaskaGodinaDto {

	private String vrednost;
	private Boolean trenutna;
	public SkolaskaGodinaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkolaskaGodinaDto(String vrednost, Boolean trenutna) {
		super();
		this.vrednost = vrednost;
		this.trenutna = trenutna;
	}
	public String getVrednost() {
		return vrednost;
	}
	public void setVrednost(String vrednost) {
		vrednost = vrednost;
	}
	public Boolean getTrenutna() {
		return trenutna;
	}
	public void setTrenutna(Boolean trenutna) {
		this.trenutna = trenutna;
	}
}
