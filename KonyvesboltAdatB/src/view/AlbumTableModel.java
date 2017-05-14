package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.AlbumDao;
import model.Album;

public class AlbumTableModel extends AbstractTableModel
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1268103299102232362L;
	private static final String[] COLUMN_NAMES={"ID","Cím","Előadó","Műfaj","Ár"};
	private List<Album> Albumok = AlbumDao.getAlbumok();

	public List<Album> getAlbumok() {
		return Albumok;
	}

	public void setAlbumok(List<Album> albumok) {
		Albumok = albumok;
	}
	
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Albumok.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Album album = Albumok.get(rowIndex);
		
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

}
