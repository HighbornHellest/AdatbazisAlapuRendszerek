package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Raktar;

/**
 * @author Tamássy Urmás
 *
 */
public class RaktarDao {
	/**
	 * Id alapján módosít egy sort.
	 * @param raktarId
	 * @param raktar
	 */
	public static void update(int raktarId, Raktar raktar){
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("update RAKTAR set TERMEKID=?, TERMEKTIPUS=?, DARAB=?, ARUHAZID=? WHERE ID=?");
			try{
				s.setInt(1, raktar.getTermek().getId());
				s.setString(2, raktar.getTermek().getTipus());
				s.setInt(3, raktar.getDarab());
				s.setInt(4, raktar.getAruhaz().getId());
				s.setInt(5, raktarId);
				s.execute();
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 *  Csökkenti egy sor(termék és áruház alapján)) darab attribútumát 1-el.
	 * @param aruhazId
	 * @param termekId
	 * @param termekTipus
	 */
	public static void keszletCsokkentes(int aruhazId,int termekId,String termekTipus){
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("update RAKTAR set DARAB=DARAB-1 WHERE TERMEKID=? AND ARUHAZID=? AND TERMEKTIPUS LIKE ?");
			try{
				s.setInt(1, termekId);
				s.setInt(2, aruhazId);
				s.setString(3, termekTipus);
				s.execute();
			}finally{
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Lekéri a termék készletét, -1 ha nincs találat.
	 * @param aruhazId
	 * @param termekId
	 * @param termekTipus
	 * @return
	 */
	public static int keszlet(int aruhazId,int termekId,String termekTipus){
		int darab=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT DARAB FROM RAKTAR WHERE TERMEKID=? AND ARUHAZID=? AND TERMEKTIPUS LIKE ?");
			try{
				s.setInt(1, termekId);
				s.setInt(2, aruhazId);
				s.setString(3, termekTipus);
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()){
						darab=rs.getInt(1);
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
		return darab;
	}
	public static int addRaktar(Raktar raktar){
		int id=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO RAKTAR (TERMEKID,TERMEKTIPUS,DARAB,ARUHAZID) VALUES (?,?,?,?)",new String[]{"ID"});
			try{
				s.setInt(1, raktar.getTermek().getId());
				s.setString(2, raktar.getTermek().getTipus());
				s.setInt(3, raktar.getDarab());
				s.setInt(4, raktar.getAruhaz().getId());
				
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()){
						id=rs.getInt(1);
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
		return id;
	}
}
