package model;

import javax.swing.table.AbstractTableModel;

public abstract class ResettableTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2045539605159174796L;

	public abstract void reset();
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	public abstract void delete(Integer id);
}
