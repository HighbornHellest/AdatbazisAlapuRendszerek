package model;

/**
 * @author Tamássy Urmás
 *
 */
public class Termek {
	private int id;
	private String cim;
	private int ar;
	private String tipus;
	public Termek(int id, String cim, int ar, String tipus) {
		super();
		this.id = id;
		this.cim = cim;
		this.ar = ar;
		this.tipus=tipus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCim() {
		return cim;
	}
	public void setCim(String cim) {
		this.cim = cim;
	}
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
}
