package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Rendeles;

/**
 * @author Tamássy Urmás
 *
 */
public class RendelesDao {
	/**
	 * Hozzáad egy rendelést és visszatér a rendelés(!!!) id-jével
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
}
