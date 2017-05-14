package model;

import dao.KonyvesboltDao;

/**
 * @author Tamássy Urmás
 *
 */
public class Album extends Termek{
	private String eloado;
	private String mufaj;
	public Album(int id, String eloado, String cim, String mufaj, int ar) {
		super(id, cim, ar, KonyvesboltDao.TERMEK_TIPUS_ALBUM);
		this.eloado = eloado;
		this.mufaj = mufaj;
	}
	
	public Album() {
		super();
	}

	public String getEloado() {
		return eloado;
	}
	public void setEloado(String eloado) {
		this.eloado = eloado;
	}
	public String getMufaj() {
		return mufaj;
	}
	public void setMufaj(String mufaj) {
		this.mufaj = mufaj;
	}

	public void setFromArray(String[] array) {
		setId(Integer.parseInt(array[0]));
		setEloado(array[2]);
		setCim(array[1]);
		setMufaj(array[3]);
		setAr(Integer.parseInt(array[4]));
		
	}

	public String[] toArray() {
		String[] array=new String[5];
		array[0]=Integer.toString(getId());
		array[2]=getEloado();
		array[1]=getCim();
		array[3]=getMufaj();
		array[4]=Integer.toString(getAr());
		return array;
	}
}
