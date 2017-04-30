package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Album;

/**
 * @author Tamássy Urmás
 *
 */
public class AlbumDao {
	/**
	 * Albumok hozzáadása
	 * @param album
	 * @return
	 */
	public static int addAlbum(Album album){
		int id=0;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO ALBUM(ELOADO, CIM, MUFAJ, AR)"+
		" VALUES (?, ?, ?, ?)"
					, new String[]{"ID"});
			try{
				s.setString(1, album.getEloado());
				s.setString(2, album.getCim());
				s.setString(3, album.getMufaj());
				s.setInt(4, album.getAr());
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
