package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import dao.AlkalmazottDao;

public class AlkalmazottTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1268103299102232362L;
	public static final String[] COLUMN_NAMES={"ID","Név","Szülidő","Fizetés","Beosztás", "Munkaviszony", "Cím","ÁruházId"};
	private List<Alkalmazott> alkalmazottak = AlkalmazottDao.getAlkalmazottak();
	
	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return alkalmazottak.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Alkalmazott alkalmazott = alkalmazottak.get(rowIndex);
		
		switch(columnIndex)
		{
			case 0:
			{
			return alkalmazott.getId();
			}
			case 1:
			{
				return alkalmazott.getNev();
			}
			case 2:
			{
				return alkalmazott.getSzulIdo();
			}
			case 3:
			{
				return alkalmazott.getFizetes();
			}
			case 4:
			{
				return alkalmazott.getBeosztas();
			}
			case 5:
			{
				return alkalmazott.getMunkaviszony();
			}
			case 6:
			{
				return alkalmazott.getCim();
			}
			case 7:
			{
				return alkalmazott.getAruhaz().getId();
			}
			
			default:
			{
				break;
			}
		}
		
		
		
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==0) return false;
		else return true;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Alkalmazott alkalmazott=alkalmazottak.get(rowIndex);
		String[] array=alkalmazott.toArray();
		array[columnIndex]=aValue.toString();
		alkalmazott.setFromArray(array);
		AlkalmazottDao.updateAlkalmazott(alkalmazott.getId(), alkalmazott);
		//albumok.set(rowIndex, album);
		reset();
	}

	public void reset() {
		alkalmazottak=AlkalmazottDao.getAlkalmazottak();
		fireTableDataChanged();
	}

}
