package model;

import java.util.List;

import dao.AlbumDao;

public class AlbumTableModel extends ResettableTableModel
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7173144406878382961L;
	public static final String[] COLUMN_NAMES={"ID","Cím","Előadó","Műfaj","Ár"};
	private List<Album> albumok = AlbumDao.getAlbumok();

	public List<Album> getAlbumok() {
		return albumok;
	}

	public void setAlbumok(List<Album> albumok) {
		this.albumok = albumok;
	}
	
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return albumok.size();
	}
	
	@Override
	public String getColumnName(int column) {
		if(column==COLUMN_NAMES.length) return "Törlés";
		return COLUMN_NAMES[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Album album = albumok.get(rowIndex);
		
		switch(columnIndex)
		{
			case 0:
			{
			return album.getId();
			}
			case 1:
			{
				return album.getCim();
			}
			case 2:
			{
				return album.getEloado();
			}
			case 3:
			{
				return album.getMufaj();
			}
			case 4:
			{
				return album.getAr();
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
		Album album=albumok.get(rowIndex);
		String[] array=album.toArray();
		array[columnIndex]=aValue.toString();
		album.setFromArray(array);
		AlbumDao.updateAlbum(album.getId(), album);
		//albumok.set(rowIndex, album);
		reset();
	}

	public void reset() {
		albumok=AlbumDao.getAlbumok();
		fireTableDataChanged();
	}

	@Override
	public void delete(Integer id) {
		AlbumDao.delete(id);
		
	}

}
