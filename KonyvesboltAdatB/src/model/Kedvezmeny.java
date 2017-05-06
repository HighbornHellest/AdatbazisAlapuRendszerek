package model;

public class Kedvezmeny {
	private int id;
	private Konyv konyv;
	private int kedvezmenySzazalek;
	
	public Kedvezmeny(int id, Konyv konyv, int kedvezmenySzazalek) {
		super();
		this.id = id;
		this.konyv = konyv;
		this.kedvezmenySzazalek = kedvezmenySzazalek;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Konyv getKonyv() {
		return konyv;
	}
	public void setKonyv(Konyv konyv) {
		this.konyv = konyv;
	}
	public int getKedvezmenySzazalek() {
		return kedvezmenySzazalek;
	}
	public void setKedvezmenySzazalek(int kedvezmenySzazalek) {
		this.kedvezmenySzazalek = kedvezmenySzazalek;
	}
}
