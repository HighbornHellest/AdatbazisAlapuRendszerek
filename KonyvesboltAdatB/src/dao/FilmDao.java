package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Film;

/**
 * @author Tamássy Urmás
 *
 */
public class FilmDao {
	/**
	 * Filmek hozzáadása
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
}
