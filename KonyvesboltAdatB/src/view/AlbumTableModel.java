package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.AlbumDao;
import dao.KonyvDao;
import model.Album;
import model.Konyv;

public class AlbumTableModel extends AbstractTableModel
{
	
	
	private List<Album> Albumok = AlbumDao.getAlbumok();

	public List<Album> getAlbumok() {
		return Albumok;
	}

	public void setAlbumok(List<Album> albumok) {
		Albumok = albumok;
	}
	
	
	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Albumok.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		
		switch(column)
		{
			case 0:
			{return "ID";}
			case 1:
			{return "cím";}
			case 2:
			{return "Eloado";}
			case 3:
			{return "Mufaj";}
			case 4:
			{return "Tipus";}
			case 5:
			{return "Ar";}
			

			//todo minden név
		
		}
		
		
		return super.getColumnName(column);
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
				return album.getTipus();
			}
			case 5:
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
