package com.iktpreobuka.skolskidnevnik.dto;


public class OdeljenjeDto {
    private String naziv;

	public OdeljenjeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OdeljenjeDto(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
    
}
