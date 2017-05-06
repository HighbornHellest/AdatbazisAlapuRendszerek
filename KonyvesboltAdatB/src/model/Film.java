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
}
