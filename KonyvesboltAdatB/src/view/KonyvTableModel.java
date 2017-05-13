package view;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.KonyvDao;
import model.Konyv;

public class KonyvTableModel extends AbstractTableModel {

	private List<Konyv> konyvek = KonyvDao.getKonyvek();

	public KonyvTableModel() {
		super();
	}

	public List<Konyv> getKonyvek() {
		return konyvek;
	}

	public void setKonyvek(List<Konyv> konyvek) {
		this.konyvek = konyvek;
	}

	@Override
	public int getColumnCount() {
		return 17;
	}

	@Override
	public int getRowCount() {
		return konyvek.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Konyv konyv = konyvek.get(arg0);
		switch (arg1) {
		case 0:
			return konyv.getId();
		case 1:
			return konyv.getCim();
		case 2:
			return konyv.getOldalSzam();
		case 3:
			return konyv.getKiadIdo();
		case 4:
			return konyv.getHanyadikKiadas();
		case 5:
			return konyv.getSzerzo();
		case 6:
			return konyv.getTarsSzerzo();
		case 7:
			return konyv.getKiado();
		case 8:
			return konyv.getVasarlasSzam();
		case 9:
			return konyv.getMeret();
		case 10:
			return konyv.getKotes();
		case 11:
			return konyv.getAr();
		case 12:
			return konyv.getMufaj();
		case 13:
			return konyv.getAlMufaj();
		case 14:
			return konyv.isEbook();
		case 15:
			return konyv.isCsakEb();
		case 16:
			return konyv.getIsbn13();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return !(columnIndex==0||columnIndex==3);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String value=(String) aValue;
		switch (columnIndex) {
		case 0:
			konyvek.get(rowIndex).setId(Integer.parseInt(value));
			break;
		case 1:
			konyvek.get(rowIndex).setCim(value);
			break;
		case 2:
			konyvek.get(rowIndex).setOldalSzam(Integer.parseInt(value));
			break;
		case 3:
			konyvek.get(rowIndex).setKiadIdo(new Date(Date.parse(value)));
			break;
		case 4:
			konyvek.get(rowIndex).setHanyadikKiadas(value);
			break;
		case 5:
			konyvek.get(rowIndex).setSzerzo(value);
			break;
		case 6:
			konyvek.get(rowIndex).setTarsSzerzo(value);
			break;
		case 7:
			konyvek.get(rowIndex).setKiado(value);
			break;
		case 8:
			konyvek.get(rowIndex).setVasarlasSzam(Integer.parseInt(value));
			break;
		case 9:
			konyvek.get(rowIndex).setMeret(value);
			break;
		case 10:
			konyvek.get(rowIndex).setKotes(value);
			break;
		case 11:
			konyvek.get(rowIndex).setAr(Integer.parseInt(value));
			break;
		case 12:
			konyvek.get(rowIndex).setMufaj(value);
			break;
		case 13:
			konyvek.get(rowIndex).setAlMufaj(value);
			break;
		case 14:
			konyvek.get(rowIndex).setEbook(Boolean.parseBoolean(value));
			break;
		case 15:
			konyvek.get(rowIndex).setCsakEb(Boolean.parseBoolean(value));
			break;
		case 16:
			konyvek.get(rowIndex).setIsbn13(Long.parseLong(value));
			break;
		default:
			break;
		}
		KonyvDao.updateKonyv(konyvek.get(rowIndex).getId(), konyvek.get(rowIndex));
	}

}
