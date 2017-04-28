package model;

public class Album extends Termek{
	private String eloado;
	private String mufaj;
	public Album(int id, String eloado, String cim, String mufaj, int ar) {
		super(id, cim, ar);
		this.eloado = eloado;
		this.mufaj = mufaj;
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
}
