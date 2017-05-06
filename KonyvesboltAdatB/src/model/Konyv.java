package model;

import java.sql.Date;

import dao.KonyvesboltDao;

/**
 * @author Tamássy Urmás
 *
 */
public class Konyv extends Termek{
	private int oldalSzam;
	private Date kiadIdo;
	// int?
	private String hanyadikKiadas;
	private String szerzo;
	private String tarsSzerzo;
	private String kiado;
	private int vasarlasSzam;
	private String meret;
	private String kotes;
	private String mufaj;
	private String alMufaj;
	private boolean ebook;
	private boolean csakEb;
	private int isbn13;
	
	public Konyv(int id, String cim, int oldalSzam, Date kiadIdo, String hanyadikKiadas, String szerzo,
			String tarsSzerzo, String kiado, int vasarlasSzam, String meret, String kotes, int ar, String mufaj,
			String alMufaj, boolean ebook, boolean csakEb, int isbn13) {
		super(id, cim, ar, KonyvesboltDao.TERMEK_TIPUS_KONYV);
		this.oldalSzam = oldalSzam;
		this.kiadIdo = kiadIdo;
		this.hanyadikKiadas = hanyadikKiadas;
		this.szerzo = szerzo;
		this.tarsSzerzo = tarsSzerzo;
		this.kiado = kiado;
		this.vasarlasSzam = vasarlasSzam;
		this.meret = meret;
		this.kotes = kotes;
		this.mufaj = mufaj;
		this.alMufaj = alMufaj;
		this.ebook = ebook;
		this.csakEb = csakEb;
		this.isbn13 = isbn13;
	}
	public int getOldalSzam() {
		return oldalSzam;
	}
	public void setOldalSzam(int oldalSzam) {
		this.oldalSzam = oldalSzam;
	}
	public Date getKiadIdo() {
		return kiadIdo;
	}
	public void setKiadIdo(Date kiadIdo) {
		this.kiadIdo = kiadIdo;
	}
	public String getHanyadikKiadas() {
		return hanyadikKiadas;
	}
	public void setHanyadikKiadas(String hanyadikKiadas) {
		this.hanyadikKiadas = hanyadikKiadas;
	}
	public String getSzerzo() {
		return szerzo;
	}
	public void setSzerzo(String szerzo) {
		this.szerzo = szerzo;
	}
	public String getTarsSzerzo() {
		return tarsSzerzo;
	}
	public void setTarsSzerzo(String tarsSzerzo) {
		this.tarsSzerzo = tarsSzerzo;
	}
	public String getKiado() {
		return kiado;
	}
	public void setKiado(String kiado) {
		this.kiado = kiado;
	}
	public int getVasarlasSzam() {
		return vasarlasSzam;
	}
	public void setVasarlasSzam(int vasarlasSzam) {
		this.vasarlasSzam = vasarlasSzam;
	}
	public String getMeret() {
		return meret;
	}
	public void setMeret(String meret) {
		this.meret = meret;
	}
	public String getKotes() {
		return kotes;
	}
	public void setKotes(String kotes) {
		this.kotes = kotes;
	}
	public String getMufaj() {
		return mufaj;
	}
	public void setMufaj(String mufaj) {
		this.mufaj = mufaj;
	}
	public String getAlMufaj() {
		return alMufaj;
	}
	public void setAlMufaj(String alMufaj) {
		this.alMufaj = alMufaj;
	}
	public boolean isEbook() {
		return ebook;
	}
	public void setEbook(boolean ebook) {
		this.ebook = ebook;
	}
	public boolean isCsakEb() {
		return csakEb;
	}
	public void setCsakEb(boolean csakEb) {
		this.csakEb = csakEb;
	}
	public int getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(int isbn13) {
		this.isbn13 = isbn13;
	}
	
}
