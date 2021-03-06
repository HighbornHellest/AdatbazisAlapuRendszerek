package model;

/**
 * @author Tamássy Urmás
 *
 */
public class Vasarlo {
	private int id;
	private String nev;
	private String szamlaCim;
	private String szallitCim;
	private String szallitCim2;
	//DB-ben String?
	private boolean torzsE;
	private int osszesKoltseg;
	private int tetelSzam;
	
	public Vasarlo(int id, String nev, String szamlaCim, String szallitCim, String szallitCim2, boolean torzsE,
			int osszesKoltseg, int tetelSzam) {
		super();
		this.id = id;
		this.nev = nev;
		this.szamlaCim = szamlaCim;
		this.szallitCim = szallitCim;
		this.szallitCim2 = szallitCim2;
		this.torzsE = torzsE;
		this.osszesKoltseg = osszesKoltseg;
		this.tetelSzam = tetelSzam;
	}
	public Vasarlo() {
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
	public String getSzamlaCim() {
		return szamlaCim;
	}
	public void setSzamlaCim(String szamlaCim) {
		this.szamlaCim = szamlaCim;
	}
	public String getSzallitCim() {
		return szallitCim;
	}
	public void setSzallitCim(String szallitCim) {
		this.szallitCim = szallitCim;
	}
	public String getSzallitCim2() {
		return szallitCim2;
	}
	public void setSzallitCim2(String szallitCim2) {
		this.szallitCim2 = szallitCim2;
	}
	public boolean isTorzsE() {
		return torzsE;
	}
	public void setTorzsE(boolean torzsE) {
		this.torzsE = torzsE;
	}
	public int getOsszesKoltseg() {
		return osszesKoltseg;
	}
	public void setOsszesKoltseg(int osszesKoltseg) {
		this.osszesKoltseg = osszesKoltseg;
	}
	public int getTetelSzam() {
		return tetelSzam;
	}
	public void setTetelSzam(int tetelSzam) {
		this.tetelSzam = tetelSzam;
	}
	public String[] toArray() {
		String[] array = new String[8];
		array[0] = Integer.toString(getId());
		array[1] = nev;
		array[2] = szamlaCim;
		array[3] = szallitCim;
		array[4] = szallitCim2;
		array[5] = Boolean.toString(torzsE);
		array[6] = Integer.toString(osszesKoltseg);
		array[7] = Integer.toString(tetelSzam);
		
		return array;
	}

	public void setFromArray(String[] array) {
		setId(Integer.parseInt(array[0]));
		nev=array[1];
		szamlaCim=array[2];
		szallitCim=array[3];
		szallitCim2=array[4];
		torzsE=Boolean.parseBoolean(array[5]);
		osszesKoltseg=Integer.parseInt(array[6]);
		tetelSzam=Integer.parseInt(array[7]);
	}
	
}
