package model;

import java.util.List;

import dao.AruhazDao;

public class AruhazTableModel extends ResettableTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1268103299102232362L;
	public static final String[] COLUMN_NAMES={"ID","Cím","Dolgozószám","Nyitvatartás"};
	private List<Aruhaz> aruhazak = AruhazDao.getAruhazak();
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return aruhazak.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Aruhaz aruhaz = aruhazak.get(rowIndex);
		
		switch(columnIndex)
		{
			case 0:
			{
			return aruhaz.getId();
			}
			case 1:
			{
				return aruhaz.getCim();
			}
			case 2:
			{
				return aruhaz.getDolgozoSzam();
			}
			case 3:
				return aruhaz.getNyitvatart();
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
		Aruhaz aruhaz=aruhazak.get(rowIndex);
		String[] array=aruhaz.toArray();
		array[columnIndex]=aValue.toString();
		aruhaz.setFromArray(array);
		AruhazDao.updateAruhaz(aruhaz.getId(), aruhaz);
		//albumok.set(rowIndex, album);
		reset();
	}

	public void reset() {
		aruhazak=AruhazDao.getAruhazak();
		fireTableDataChanged();
	}

	@Override
	public void delete(Integer id) {
		AruhazDao.delete(id);
		
	}
}
