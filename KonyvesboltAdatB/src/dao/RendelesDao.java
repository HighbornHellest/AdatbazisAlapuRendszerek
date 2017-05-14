package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rendeles;
import model.Vasarlo;

/**
 * @author Tamássy Urmás
 *
 */
public class RendelesDao {
	/**
	 * Hozzáad több rendelést és visszatér a rendelés(!!!) id-jével
	 * @param rendelesek
	 * @return
	 */
	public static int addRendelesek(List<Rendeles> rendelesek){
		int rendelesId=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT RENDELESID_SEQ.NEXTVAL FROM dual");
			try{
				ResultSet rs=s.executeQuery();
				try{
					if(rs.next()) rendelesId=rs.getInt(1);
					for(Rendeles rendeles:rendelesek){
						rendeles.setRendelesId(rendelesId);
						addRendeles(rendeles);
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
		
		return rendelesId;
	}
	/**
	 * Hozzáad egy sort a rendelés táblába (használd az addrendelesek-et). Visszatér a sor id-jével
	 * @param rendeles
	 * @return
	 */
	public static int addRendeles(Rendeles rendeles){
		int id=-1;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO RENDELES"+
					" (TERMEKID, TERMEKTIPUS, VASARLOID, RENDELESID)"+
					" VALUES (?, ?, ?, ?)"
								, new String[]{"ID"});
			try{
				s.setInt(1, rendeles.getTermek().getId());
				s.setString(2, rendeles.getTermek().getTipus());
				s.setInt(3, rendeles.getVasarlo().getId());
				s.setInt(4, rendeles.getRendelesId());
				s.execute();
				ResultSet rs=s.getGeneratedKeys();
				try{
					id=rs.getInt(1);
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
	 * Lekéri az összes rendelést
	 * @return
	 */
	public static List<Rendeles> getRendelesek(){
		List<Rendeles> list=new ArrayList<Rendeles>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "RENDELES.ID,RENDELES.TERMEKID,RENDELES.TERMEKTIPUS,RENDELES.VASARLOID,RENDELES.RENDELESID,VASARLO.NEV, VASARLO.SZAMLACIM,"
			+ "VASARLO.SZALLITCIM, VASARLO.SZALLITCIM2, VASARLO.TORZSE, VASARLO.OSSZESKOLTSEG,VASARLO.TETELSZAM"
			+ " FROM RENDELES,VASARLO WHERE VASARLO.ID=RENDELES.VASARLOID");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Rendeles(rs.getInt(1),TermekDao.getTermek(rs.getInt(2), rs.getString(3)),
								new Vasarlo(rs.getInt(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10),
										rs.getInt(11), rs.getInt(12)),rs.getInt(5)));
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
