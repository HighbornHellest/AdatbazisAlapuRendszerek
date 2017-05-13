package view;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.KedvezmenyDao;
import model.Kedvezmeny;;

public class KedvezmenyTableModel extends AbstractTableModel {
	private List<Kedvezmeny> kedvezmenyek = KedvezmenyDao.getKedvezmenyek();

	public List<Kedvezmeny> getKedvezmenyek() {
		return kedvezmenyek;
	}

	public void setKedvezmenyek(List<Kedvezmeny> kedvezmenyek) {
		this.kedvezmenyek = kedvezmenyek;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return kedvezmenyek.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Kedvezmeny kedvezmeny = kedvezmenyek.get(arg0);
		switch (arg1) {
		case 0:
			return kedvezmeny.getId();
		case 1:
			return kedvezmeny.getKonyv();
		case 2:
			return kedvezmeny.getKedvezmenySzazalek();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return !(columnIndex==0);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String value=(String) aValue;
		switch (columnIndex) {
		case 0:
			kedvezmenyek.get(rowIndex).setId(Integer.parseInt(value));
			break;
		case 1:
			kedvezmenyek.get(rowIndex).getKonyv().setId(Integer.parseInt(value));
			break;
		case 2:
			kedvezmenyek.get(rowIndex).setKedvezmenySzazalek(Integer.parseInt(value));
			break;
		default:
			break;
		}
		KedvezmenyDao.updateKedvezmeny(kedvezmenyek.get(rowIndex).getId(),kedvezmenyek.get(rowIndex));
	}

}
