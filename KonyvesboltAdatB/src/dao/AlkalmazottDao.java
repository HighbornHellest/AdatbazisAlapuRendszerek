package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Alkalmazott;
import model.Aruhaz;

/**
 * @author Tamássy Urmás
 *
 */
public class AlkalmazottDao {
	/**
	 * Hozzáad egy alkalmazottat
	 * @param alkalmazott
	 * @return
	 */
	public static int addAlkalmazott(Alkalmazott alkalmazott){
		int id=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO ALKALMAZOTT (NEV,SZULIDO,FIZETES,BEOSZTAS,MUMKAVISZONY,ARUHAZID)"+
		" VALUES (?, ?, ?, ?,?,?)"
					, new String[]{"ID"});
			try{
				s.setString(1, alkalmazott.getNev());
				s.setDate(2, alkalmazott.getSzulIdo());
				s.setInt(3, alkalmazott.getFizetes());
				s.setString(4, alkalmazott.getBeosztas());
				s.setString(5, alkalmazott.getMunkaviszony());
				s.setInt(6, alkalmazott.getAruhaz().getId());
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
	 * Lekéri az összesa alkalmazottat
	 * @return
	 */
	public static List<Alkalmazott> getAlkalmazottak(){
		List<Alkalmazott> list=new ArrayList<Alkalmazott>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ALKALMAZOTT.ID,ALKALMAZOTT.NEV,ALKALMAZOTT.SZULIDO,ALKALMAZOTT.FIZETES,ALKALMAZOTT.BEOSZTAS,ALKALMAZOTT.MUNKAVISZONY,ALKALMAZOTT.CIM,"
			+ "ALKALMAZOTT.ARUHAZID,ARUHAZ.CIM,ARUHAZ.DOLGOZOSZAM,ARUHAZ.NYITVATART"
			+ " FROM ALKALMAZOTT,ARUHAZ WHERE ARUHAZ.ID=ALKALMAZOTT.ARUHAZID");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Alkalmazott(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7),
								new Aruhaz(rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11))));
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
