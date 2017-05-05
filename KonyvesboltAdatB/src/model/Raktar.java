package model;

public class Raktar {
	private int id;
	private Termek termek;
	private int darab;
	private Aruhaz aruhaz;
	public Raktar(int id, Termek termek, int darab, Aruhaz aruhaz) {
		super();
		this.id = id;
		this.termek = termek;
		this.darab = darab;
		this.aruhaz = aruhaz;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Termek getTermek() {
		return termek;
	}
	public void setTermek(Termek termek) {
		this.termek = termek;
	}
	public int getDarab() {
		return darab;
	}
	public void setDarab(int darab) {
		this.darab = darab;
	}
	public Aruhaz getAruhaz() {
		return aruhaz;
	}
	public void setAruhaz(Aruhaz aruhaz) {
		this.aruhaz = aruhaz;
	}

	
}
