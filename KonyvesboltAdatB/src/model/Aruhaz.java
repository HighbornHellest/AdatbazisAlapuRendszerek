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
	public Aruhaz() {
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
	public String[] toArray() {
		String[] array=new String[4];
		array[0]=Integer.toString(id);
		array[1]=cim;
		array[2]=Integer.toString(dolgozoSzam);
		array[3]=nyitvatart;		
		return array;
	}
	public void setFromArray(String[] array) {
		id=Integer.parseInt(array[0]);
		cim=array[1];
		dolgozoSzam=Integer.parseInt(array[2]);
		nyitvatart=array[3];
		
	}
	
}
