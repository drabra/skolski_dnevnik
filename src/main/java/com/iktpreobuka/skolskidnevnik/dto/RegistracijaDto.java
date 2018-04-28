package com.iktpreobuka.skolskidnevnik.dto;

public class RegistracijaDto {
	
	private int uloga; //1-ucenik  2-nastavnik  3-roditelj
	private String ime;
	private String prezime;
	private String korisnickalozinka;
	private String korisnickoIme;
	private Integer idRoditelja;
	
	public RegistracijaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistracijaDto(int uloga, String ime, String prezime, String korisnickalozinka, String korisnickoIme,
			Integer idRoditelja) {
		super();
		this.uloga = uloga;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickalozinka = korisnickalozinka;
		this.korisnickoIme = korisnickoIme;
		this.idRoditelja = idRoditelja;
	}
	public int getUloga() {
		return uloga;
	}
	public void setUloga(int uloga) {
		this.uloga = uloga;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getKorisnickalozinka() {
		return korisnickalozinka;
	}
	public void setKorisnickalozinka(String korisnickalozinka) {
		this.korisnickalozinka = korisnickalozinka;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public Integer getImeRoditelja() {
		return idRoditelja;
	}
	public void setImeRoditelja(Integer imeRoditelja) {
		this.idRoditelja = imeRoditelja;
	}
	

}
