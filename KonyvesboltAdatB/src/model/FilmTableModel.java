package model;

import java.util.List;

import dao.FilmDao;

public class FilmTableModel extends ResettableTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5503452980432821789L;
	private List<Film> filmek = FilmDao.getFilmek();
	public static final String[] COLUMN_NAMES={"ID","Cím","Műfaj","Blueray","Rendező","ár"};
	public List<Film> getFilmek() {
		return filmek;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	public void setFilmek(List<Film> filmek) {
		this.filmek = filmek;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return filmek.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Film film = filmek.get(arg0);
		switch (arg1) {
		case 0:
			return film.getId();
		case 1:
			return film.getCim();
		case 2:
			return film.getMufaj();
		case 3:
			return film.isBluerayE();
		case 4:
			return film.getRendezo();
		case 5:
			return film.getAr();
	
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
		String value=aValue.toString();
		switch (columnIndex) {
		case 0:
			filmek.get(rowIndex).setId(Integer.parseInt(value));
			break;
		case 1:
			filmek.get(rowIndex).setCim(value);
			break;
		case 2:
			filmek.get(rowIndex).setMufaj(value);
			break;
		case 3:
			filmek.get(rowIndex).setBluerayE(Boolean.parseBoolean(value));
			break;	
		case 4:
			filmek.get(rowIndex).setRendezo(value);
			break;
		case 5:
			filmek.get(rowIndex).setAr(Integer.parseInt(value));
		default:
			break;
		}
		FilmDao.updateFilm(filmek.get(rowIndex).getId(),filmek.get(rowIndex));
	}
	public void reset(){
		filmek=FilmDao.getFilmek();
		fireTableDataChanged();
	}

	@Override
	public void delete(Integer id) {
		FilmDao.delete(id);
	}
}
