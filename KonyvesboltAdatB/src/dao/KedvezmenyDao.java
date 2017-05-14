package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Kedvezmeny;

/**
 * @author Tamássy Urmás
 *
 */
public class KedvezmenyDao {
	/**
	 * Hozzáad egy kedvezményt
	 * @param kedvezmeny
	 * @return
	 */
	public static int addKedvezmeny(Kedvezmeny kedvezmeny){
		int id=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO KEDVEZMENY(KONYVID,KEDVEZMENYSZAZALEK)"+
		" VALUES (?, ?, ?, ?)"
					, new String[]{"ID"});
			try{
				s.setInt(1, kedvezmeny.getKonyv().getId());
				s.setInt(2, kedvezmeny.getKedvezmenySzazalek());
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
	/**
	 * Lekéri az összes kedvezményt
	 * @return
	 */
	public static List<Kedvezmeny> getKedvezmenyek(){
		List<Kedvezmeny> list=new ArrayList<Kedvezmeny>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,KONYVID,KEDVEZMENYSZAZALEK"
			+ " FROM KEDVEZMENY");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Kedvezmeny(rs.getInt(1),KonyvDao.getKonyvIdSzerint(rs.getInt(2)),rs.getInt(3)));
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
	public static void updateKedvezmeny(int kedvezmenyId,Kedvezmeny kedvezmeny){
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("UPDATE KEDVEZMENY SET KONYVID=?,KEDVEZMENYSZAZALEK=? WHERE ID=?");
			try{
				s.setInt(1, kedvezmeny.getKonyv().getId());
				s.setInt(2, kedvezmeny.getKedvezmenySzazalek());
				s.setInt(3, kedvezmenyId);
				s.executeQuery();
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
