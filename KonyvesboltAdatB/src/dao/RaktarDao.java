package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Aruhaz;
import model.Raktar;
import model.Termek;


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
	 *  Csökkenti egy sor(termék és áruház alapján) darab attribútumát 1-el.
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
	/**
	 * Hozzáad egy raktárat (adott termék darabszámmal)
	 * @param raktar
	 * @return
	 */
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
	/**
	 * Visszaadja az összes tárolt terméket
	 * @return
	 */
	public static List<Raktar> getRaktarak(){
		List<Raktar> list=new ArrayList<Raktar>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "RAKTAR.ID,RAKTAR.TERMEKID,RAKTAR.TERMEKTIPUS,RAKTAR.DARAB,RAKTAR.ARUHAZID,ARUHAZ.CIM,ARUHAZ.DOLGOZOSZAM,ARUHAZ.NYITVATART"
			+ " FROM RAKTAR,ARUHAZ WHERE RAKTAR.ARUHAZID=ARUHAZ.ID");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						String termekTipus=rs.getString(3);
						int termekId=rs.getInt(2);
						Termek termek=TermekDao.getTermek(termekId, termekTipus);
						list.add(new Raktar(rs.getInt(1), termek,
								rs.getInt(4), new Aruhaz(rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8))));
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
	public Map<String,Integer> getKonyvDarabMufajSzerint(){
		HashMap<String, Integer> result=new HashMap<String,Integer>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT SUM(RAKTAR.DARAB),KONYV.MUFAJ FROM RAKTAR,KONYV WHERE RAKTAR.TERMEKID=KONYV.ID AND RAKTAR.TERMEKTIPUS LIKE ?");
			try{
				s.setString(1, KonyvesboltDao.TERMEK_TIPUS_KONYV);
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						result.put(rs.getString(2), rs.getInt(1));
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
		return result;
	}
}
