package com.iktpreobuka.skolskidnevnik.util;

import java.util.List;

import com.iktpreobuka.skolskidnevnik.entities.Ocena;
import com.iktpreobuka.skolskidnevnik.entities.Ucenik;

public class DecijeOcene {

    private Ucenik ucenik;
    private List<Ocena> ocene;
	public DecijeOcene() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DecijeOcene(Ucenik ucenik, List<Ocena> ocene) {
		super();
		this.ucenik = ucenik;
		this.ocene = ocene;
	}
	public Ucenik getUcenik() {
		return ucenik;
	}
	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	public List<Ocena> getOcene() {
		return ocene;
	}
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}

}
