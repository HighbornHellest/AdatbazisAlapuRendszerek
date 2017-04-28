package model;

public class Rendeles {
	private int id;
	private Termek termek;
	private Vasarlo vasarlo;
	private int rendelesId;
	public Rendeles(int id, int rendelesId) {
		super();
		this.id = id;
		this.rendelesId=rendelesId;
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
	public Vasarlo getVasarlo() {
		return vasarlo;
	}
	public void setVasarlo(Vasarlo vasarlo) {
		this.vasarlo = vasarlo;
	}
	public int getRendelesId() {
		return rendelesId;
	}
	public void setRendelesId(int rendelesId) {
		this.rendelesId = rendelesId;
	}
}
