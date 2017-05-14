package model;

import java.sql.Date;


/**
 * @author Tamássy Urmás
 *
 */
public class Alkalmazott {
	private int id;
	private String nev;
	private Date szulIdo;
	private int fizetes;
	private String beosztas;
	private String munkaviszony;
	private String cim;
	private Aruhaz aruhaz;
	public Alkalmazott(int id, String nev, Date szulIdo, int fizetes, String beosztas, String munkaviszony,
			String cim,Aruhaz aruhaz) {
		super();
		this.id = id;
		this.nev = nev;
		this.szulIdo = szulIdo;
		this.fizetes = fizetes;
		this.beosztas = beosztas;
		this.munkaviszony = munkaviszony;
		this.cim = cim;
		this.aruhaz=aruhaz;
	}
	public Alkalmazott() {
		aruhaz=new Aruhaz(); 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public Date getSzulIdo() {
		return szulIdo;
	}
	public void setSzulIdo(Date szulIdo) {
		this.szulIdo = szulIdo;
	}
	public int getFizetes() {
		return fizetes;
	}
	public void setFizetes(int fizetes) {
		this.fizetes = fizetes;
	}
	public String getBeosztas() {
		return beosztas;
	}
	public void setBeosztas(String beosztas) {
		this.beosztas = beosztas;
	}
	public String getMunkaviszony() {
		return munkaviszony;
	}
	public void setMunkaviszony(String munkaviszony) {
		this.munkaviszony = munkaviszony;
	}
	public String getCim() {
		return cim;
	}
	public void setCim(String cim) {
		this.cim = cim;
	}
	public Aruhaz getAruhaz() {
		return aruhaz;
	}
	public void setAruhaz(Aruhaz aruhaz) {
		this.aruhaz = aruhaz;
	}
	public String[] toArray() {
		String[] array=new String[8];
		array[0]=Integer.toString(getId());
		array[1]=getNev();
		array[2]=getSzulIdo().toString();
		array[3]=Integer.toString(getFizetes());
		array[4]=getBeosztas();
		array[5]=getMunkaviszony();
		array[6]=getCim();
		array[7]=Integer.toString(getAruhaz().getId());
		
		return array;
	}
	public void setFromArray(String[] array) {
		id=Integer.parseInt(array[0]);
		nev=array[1];
		szulIdo=Date.valueOf(array[2]);
		fizetes=Integer.parseInt(array[3]);
		beosztas=array[4];
		munkaviszony=array[5];
		cim=array[6];
		aruhaz.setId(Integer.parseInt(array[7]));
		
	}
	
}
