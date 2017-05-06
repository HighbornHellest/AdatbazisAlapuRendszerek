package model;

/**
 * @author Tamássy Urmás
 *
 */
public class Aruhaz {
	private int id;
	private String cim;
	private int dolgozoSzam;
	private String nyitvatart;
	public Aruhaz(int id, String cim, int dolgozoSzam, String nyitvatart) {
		super();
		this.id = id;
		this.cim = cim;
		this.dolgozoSzam = dolgozoSzam;
		this.nyitvatart = nyitvatart;
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
	public int getDolgozoSzam() {
		return dolgozoSzam;
	}
	public void setDolgozoSzam(int dolgozoSzam) {
		this.dolgozoSzam = dolgozoSzam;
	}
	public String getNyitvatart() {
		return nyitvatart;
	}
	public void setNyitvatart(String nyitvatart) {
		this.nyitvatart = nyitvatart;
	}
	
}
