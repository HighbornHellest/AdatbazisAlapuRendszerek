package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aruhaz;

/**
 * @author Tamássy Urmás
 *
 */
public class AruhazDao {
	/**
	 * Hozzáad egy áruházat
	 * @param aruhaz
	 * @return
	 */
	public static int addAruhaz(Aruhaz aruhaz){
		int id=0;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO ARUHAZ(CIM,DOLGOZOSZAM,NYITVATART)"+
		" VALUES (?, ?, ?)"
					, new String[]{"ID"});
			try{
				s.setString(1, aruhaz.getCim());
				s.setInt(2, aruhaz.getDolgozoSzam());
				s.setString(3, aruhaz.getNyitvatart());
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
	 * Lekéri az összes Áruházat
	 * @return
	 */
	public static List<Aruhaz> getAruhazak(){
		List<Aruhaz> list=new ArrayList<Aruhaz>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,CIM,DOLGOZOSZAM,NYITVATART"
			+ " FROM ARUHAZ");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Aruhaz(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
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
}
