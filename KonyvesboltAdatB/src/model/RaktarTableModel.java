package model;

import java.util.List;

import dao.RaktarDao;

public class RaktarTableModel extends ResettableTableModel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 288908015933113694L;
	private List<Raktar> raktarak = RaktarDao.getRaktarak();
	public static final String[] COLUMN_NAMES={"ID","Termék ID","Termék típus","Darab","Áruház id"};

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return raktarak.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Raktar raktar = raktarak.get(arg0);
		switch (arg1) {
		case 0:
			return raktar.getId();
		case 1:
			return raktar.getTermek().getId();
		case 2:
			return raktar.getTermek().getTipus();
		case 3:
			return raktar.getDarab();
		case 4:
			return raktar.getAruhaz().getId();
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
		Raktar raktar=raktarak.get(rowIndex);
		String[] array=raktar.toArray();
		array[columnIndex]=aValue.toString();
		raktar.setFromArray(array);
		RaktarDao.update(raktar.getId(), raktar);
		reset();
	}

	@Override
	public void reset() {
		raktarak=RaktarDao.getRaktarak();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public void delete(Integer id) {
		RaktarDao.delete(id);
	}
	
}
