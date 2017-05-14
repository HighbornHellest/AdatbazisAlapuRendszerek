package model;

import java.util.List;

import dao.VasarloDao;

public class VasarloTableModel extends ResettableTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3048168550306076176L;
	private List<Vasarlo> vasarlok = VasarloDao.getVasarlok();
	public static final String[] COLUMN_NAMES={"ID","Név","Számlacím","Szállítási cím (1)","Szállítási cím (2)","Törzsvásárló","Teljes költség","Tételek száma"};

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return vasarlok.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Vasarlo vasarlo = vasarlok.get(arg0);
		switch (arg1) {
		case 0:
			return vasarlo.getId();
		case 1:
			return vasarlo.getNev();
		case 2:
			return vasarlo.getSzamlaCim();
		case 3:
			return vasarlo.getSzallitCim();
		case 4:
			return vasarlo.getSzallitCim2();
		case 5:
			return vasarlo.isTorzsE();
		case 6:
			return vasarlo.getOsszesKoltseg();
		case 7:
			return vasarlo.getTetelSzam();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex!=0;
	}

	@Override
	public void reset() {
		vasarlok=VasarloDao.getVasarlok();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public void delete(Integer id) {
		VasarloDao.delete(id);
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Vasarlo vasarlo=vasarlok.get(rowIndex);
		String[] array=vasarlo.toArray();
		array[columnIndex]=aValue.toString();
		vasarlo.setFromArray(array);
		VasarloDao.update(vasarlo.getId(), vasarlo);
		reset();
	}
}
