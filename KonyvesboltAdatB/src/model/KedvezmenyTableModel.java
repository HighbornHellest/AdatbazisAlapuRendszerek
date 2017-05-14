package model;

import java.util.List;

import dao.KedvezmenyDao;;

public class KedvezmenyTableModel extends ResettableTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -421366981554883577L;
	private List<Kedvezmeny> kedvezmenyek = KedvezmenyDao.getKedvezmenyek();
	public static final String[] COLUMN_NAMES={"ID","Könyv ID","Százalék"};

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
			return kedvezmeny.getKonyv().getId();
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

	@Override
	public void reset() {
		kedvezmenyek=KedvezmenyDao.getKedvezmenyek();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public void delete(Integer id) {
		KedvezmenyDao.delete(id);
	}
	

}
