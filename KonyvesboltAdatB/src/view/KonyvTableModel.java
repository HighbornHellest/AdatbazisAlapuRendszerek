package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.KonyvDao;
import model.Konyv;

public class KonyvTableModel extends AbstractTableModel
{
	private List<Konyv> konyvek = KonyvDao.getKonyvek();

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
	public String getColumnName(int column)
	{
		// TODO Auto-generated method stub
		//return super.getColumnName(column);
		switch(column)
		{
			case 0:
			{
				return "id";
			
			}
			//todo minden név
		
		}
		
		
		return super.getColumnName(column);
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

}
