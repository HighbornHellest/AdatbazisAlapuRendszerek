package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Film;

/**
 * @author Tam�ssy Urm�s
 *
 */
public class FilmDao {
	/**
	 * Filmek hozz�ad�sa
	 * @param film
	 * @return
	 */
	public static int addFilm(Film film){
		int id=0;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO FILM(CIM, MUFAJ, BLURAYE, RENDEZO, AR)"+
		" VALUES (?, ?, ?, ?, ?)"
					, new String[]{"ID"});
			try{
				s.setString(1, film.getCim());
				s.setString(2, film.getMufaj());
				s.setBoolean(3, film.isBluerayE());
				s.setString(4, film.getRendezo());
				s.setInt(5, film.getAr());
				s.execute();
				ResultSet rs=s.getGeneratedKeys();
				try{
					if(rs.next()) id=rs.getInt(1);
				}finally{
					rs.close();
				}
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	public static List<Film> getFilmek(){
		List<Film> list=new ArrayList<Film>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,CIM,MUFAJ,BLUERAYE,RENDEZO,AR"
			+ " FROM FILM");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getInt(6)));
					}
				}finally{
					rs.close();
				}
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Film getFilmIdSzerint(int filmId){
		Film film=null;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,CIM,MUFAJ,BLUERAYE,RENDEZO,AR"
			+ " FROM FILM where ID=?");
			try{
				s.setInt(1, filmId);
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()){
						film=new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getInt(6));
					}
				}finally{
					rs.close();
				}
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
}