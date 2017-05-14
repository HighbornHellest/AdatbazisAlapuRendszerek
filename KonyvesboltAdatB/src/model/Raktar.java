package model;

/**
 * @author Tamássy Urmás
 *
 */
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

	public Raktar() {
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

	public String[] toArray() {
		String[] array = new String[5];
		array[0] = Integer.toString(getId());
		array[1] = Integer.toString(termek.getId());
		array[2] = termek.getTipus();
		array[3] = Integer.toString(darab);
		array[4] = Integer.toString(aruhaz.getId());
		return array;
	}

	public void setFromArray(String[] array) {
		setId(Integer.parseInt(array[0]));
		termek.setId(Integer.parseInt(array[1]));
		termek.setTipus(array[2]);
		darab=Integer.parseInt(array[3]);
		aruhaz.setId(Integer.parseInt(array[4]));
	}

}
