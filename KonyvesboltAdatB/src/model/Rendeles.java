package model;

/**
 * @author Tamássy Urmás
 *
 */
public class Rendeles {
	private int id;
	private Termek termek;
	private Vasarlo vasarlo;
	private int rendelesId;
	
	public Rendeles(int id, Termek termek, Vasarlo vasarlo, int rendelesId) {
		super();
		this.id = id;
		this.termek = termek;
		this.vasarlo = vasarlo;
		this.rendelesId = rendelesId;
	}
	public Rendeles() {
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
	public String[] toArray() {
		String[] array = new String[5];
		array[0] = Integer.toString(getId());
		array[1] = Integer.toString(termek.getId());
		array[2] = termek.getTipus();
		array[3] = Integer.toString(vasarlo.getId());
		array[4] = Integer.toString(rendelesId);
		return array;
	}

	public void setFromArray(String[] array) {
		setId(Integer.parseInt(array[0]));
		termek.setId(Integer.parseInt(array[1]));
		termek.setTipus(array[2]);
		vasarlo.setId(Integer.parseInt(array[3]));
		rendelesId=Integer.parseInt(array[4]);
	}
}
