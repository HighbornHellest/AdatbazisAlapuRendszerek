package model;

import dao.KonyvesboltDao;

/**
 * @author Tamássy Urmás
 *
 */
public class Film extends Termek{

	private String mufaj;
	private boolean bluerayE;
	private String rendezo;
	public Film(int id, String cim, String mufaj, boolean bluerayE, String rendezo, int ar) {
		super(id, cim, ar,KonyvesboltDao.TERMEK_TIPUS_FILM);
		this.mufaj = mufaj;
		this.bluerayE = bluerayE;
		this.rendezo = rendezo;
	}
	public Film() {
		super();
	}
	public String getMufaj() {
		return mufaj;
	}
	public void setMufaj(String mufaj) {
		this.mufaj = mufaj;
	}
	public boolean isBluerayE() {
		return bluerayE;
	}
	public void setBluerayE(boolean bluerayE) {
		this.bluerayE = bluerayE;
	}
	public String getRendezo() {
		return rendezo;
	}
	public void setRendezo(String rendezo) {
		this.rendezo = rendezo;
	}
	public String[] toArray() {
		String[] array=new String[6];
		array[0]=Integer.toString(getId());
		array[1]=getCim();
		array[2]=getMufaj();
		array[3]=Boolean.toString(bluerayE);
		array[4]=rendezo;
		array[5]=Integer.toString(getAr());
		return array;
	}
	public void setFromArray(String[] array) {
		setId(Integer.parseInt(array[0]));
		setCim(array[1]);
		setMufaj((array[2]));
		bluerayE=Boolean.parseBoolean(array[3]);
		rendezo=array[4];
		setAr(Integer.parseInt(array[5]));
		
	}
}
