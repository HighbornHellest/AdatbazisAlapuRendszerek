package model;

import java.util.List;

import dao.RendelesDao;

public class RendelesTableModel extends ResettableTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1552938683336605237L;
	private List<Rendeles> rendelesek = RendelesDao.getRendelesek();
	public static final String[] COLUMN_NAMES={"ID","Termék ID","Termék típus","Vásárló ID","Rendelés ID"};

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return rendelesek.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Rendeles rendeles = rendelesek.get(arg0);
		switch (arg1) {
		case 0:
			return rendeles.getId();
		case 1:
			return rendeles.getTermek().getId();
		case 2:
			return rendeles.getTermek().getTipus();
		case 3:
			return rendeles.getVasarlo().getId();
		case 4:
			return rendeles.getRendelesId();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void reset() {
		rendelesek=RendelesDao.getRendelesek();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public void delete(Integer id) {
		RendelesDao.delete(id);
	}

}
