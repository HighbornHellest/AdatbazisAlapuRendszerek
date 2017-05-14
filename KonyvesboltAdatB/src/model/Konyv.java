package model;

import java.sql.Date;

import dao.KonyvesboltDao;

/**
 * @author Tamássy Urmás
 *
 */
public class Konyv extends Termek{
	private int oldalSzam=0;
	private Date kiadIdo=new Date(0);
	private String hanyadikKiadas="default";
	private String szerzo="default";
	private String tarsSzerzo="default";
	private String kiado="default";
	private int vasarlasSzam=0;
	private String meret="default";
	private String kotes="default";
	private String mufaj="default";
	private String alMufaj="default";
	private boolean ebook=false;
	private boolean csakEb=false;
	private long isbn13=0;
	public Konyv() {
		super();
	}
	public Konyv(int id, String cim, int oldalSzam, Date kiadIdo, String hanyadikKiadas, String szerzo,
			String tarsSzerzo, String kiado, int vasarlasSzam, String meret, String kotes, int ar, String mufaj,
			String alMufaj, boolean ebook, boolean csakEb, long isbn13) {
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
	public long getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(long isbn13) {
		this.isbn13 = isbn13;
	}
	public void setFromArray(String[] array){
		if(array.length==17){
			setId(Integer.parseInt(array[0]));
			setCim(array[1]);
			setOldalSzam(Integer.parseInt(array[2]));
			setKiadIdo(Date.valueOf(array[3]));
			setHanyadikKiadas(array[4]);
			setSzerzo(array[5]);
			setTarsSzerzo(array[6]);
			setKiado(array[7]);
			setVasarlasSzam(Integer.parseInt(array[8]));
			setMeret(array[9]);
			setKotes(array[10]);
			setAr(Integer.parseInt(array[11]));
			setMufaj(array[12]);
			setAlMufaj(array[13]);
			setEbook(Boolean.parseBoolean(array[14]));
			setCsakEb(Boolean.parseBoolean(array[15]));
			setIsbn13(Long.parseLong(array[16]));
		}
	}
	public String[] toArray(){
		String[] array=new String[17];
		array[0]=Integer.toString(getId());
		array[1]=getCim();
		array[2]=Integer.toString(getOldalSzam());
		array[3]=getKiadIdo().toString();
		array[4]=getHanyadikKiadas();
		array[5]=getSzerzo();
		array[6]=getTarsSzerzo();
		array[7]=getKiado();
		array[8]=Integer.toString(getVasarlasSzam());
		array[9]=getMeret();
		array[10]=getKotes();
		array[11]=Integer.toString(getAr());
		array[12]=getMufaj();
		array[13]=getAlMufaj();
		array[14]=Boolean.toString(isEbook());
		array[15]=Boolean.toString(isCsakEb());
		array[16]=Long.toString(getIsbn13());
		return array;
	}
}
