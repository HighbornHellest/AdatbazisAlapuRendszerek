package model;

import java.util.List;

import dao.AlkalmazottDao;

public class AlkalmazottTableModel extends ResettableTableModel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7888481695831595669L;
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
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Alkalmazott alkalmazott=alkalmazottak.get(rowIndex);
		String[] array=alkalmazott.toArray();
		array[columnIndex]=aValue.toString();
		alkalmazott.setFromArray(array);
		AlkalmazottDao.updateAlkalmazott(alkalmazott.getId(), alkalmazott);
		reset();
	}

	public void reset() {
		alkalmazottak=AlkalmazottDao.getAlkalmazottak();
		fireTableDataChanged();
	}

	@Override
	public void delete(Integer id) {
		AlkalmazottDao.delete(id);
		
	}

}
