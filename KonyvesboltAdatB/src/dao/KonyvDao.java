package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Konyv;

/**
 * @author Tamássy Urmás
 *
 */
public class KonyvDao {
	/**
	 * Könyvek hozzáadása
	 * @param konyv
	 * @return
	 */
	public static int addKonyv(Konyv konyv){
		int id=0;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("INSERT INTO KONYV"+
		" (CIM, OLDALSZAM, KIADIDO, HANYADIKKIADAS, SZERZO, TARSSZERZO, KIADO, VASARLASSZAM, MERET, KOTES, AR, MUFAJ, ALMUFAJ, EBOOK,CSAKEB, ISBN13)"+
		" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)"
					, new String[]{"ID"});
			try{
				s.setString(1, konyv.getCim());
				s.setInt(2, konyv.getOldalSzam());
				s.setDate(3, konyv.getKiadIdo());
				s.setString(4, konyv.getHanyadikKiadas());
				s.setString(5, konyv.getSzerzo());
				s.setString(6, konyv.getTarsSzerzo());
				s.setString(7, konyv.getKiado());
				s.setInt(8, konyv.getVasarlasSzam());
				s.setString(9, konyv.getMeret());
				s.setString(10, konyv.getKotes());
				s.setInt(11, konyv.getAr());
				s.setString(12, konyv.getMufaj());
				s.setString(13, konyv.getAlMufaj());
				s.setBoolean(14, konyv.isEbook());
				s.setBoolean(15, konyv.isCsakEb());
				s.setInt(16, konyv.getIsbn13());
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
	 * Műfaj szerint sorrendbe rakva lekéri az összes könyvet.
	 * @return
	 */
	public static List<Konyv> getKonyvekMufajSzerint(){
		List<Konyv> list=new ArrayList<Konyv>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,CIM, OLDALSZAM, KIADIDO, HANYADIKKIADAS, SZERZO, TARSSZERZO, KIADO, VASARLASSZAM, MERET, KOTES, AR, MUFAJ, ALMUFAJ, EBOOK,CSAKEB, ISBN13"
			+ " FROM KONYV ORDER BY MUFAJ");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Konyv(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
								rs.getString(10), rs.getString(11),rs.getInt(12), rs.getString(13), rs.getString(14),
								rs.getBoolean(15), rs.getBoolean(16), rs.getInt(17)));
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
	/**
	 * Alműfaj szerint sorrendbe rakva lekéri az összes könyvet.
	 * @return
	 */
	public static List<Konyv> getKonyvekAlmufajSzerint(){
		List<Konyv> list=new ArrayList<Konyv>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
			+ "ID,CIM, OLDALSZAM, KIADIDO, HANYADIKKIADAS, SZERZO, TARSSZERZO, KIADO, VASARLASSZAM, MERET, KOTES, AR, MUFAJ, ALMUFAJ, EBOOK,CSAKEB, ISBN13"
			+ " FROM KONYV ORDER BY ALMUFAJ");
			try{
				ResultSet rs=s.executeQuery();
				try{
					while(rs.next()){
						list.add(new Konyv(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
								rs.getString(10), rs.getString(11),rs.getInt(12), rs.getString(13), rs.getString(14),
								rs.getBoolean(15), rs.getBoolean(16), rs.getInt(17)));
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
	/**
	 * Egy áruház könyveit listázza.
	 * @param aruhazId
	 * @return
	 */
	public static List<Konyv> getKonyvekAruhazSzerint(int aruhazId){
		List<Konyv> list=new ArrayList<Konyv>();
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
					+ "ID,CIM, OLDALSZAM, KIADIDO, HANYADIKKIADAS, SZERZO, TARSSZERZO, KIADO, VASARLASSZAM, MERET, KOTES, AR, MUFAJ, ALMUFAJ, EBOOK,CSAKEB, ISBN13"
					+ " FROM KONYV,RAKTAR where RAKTAR.ARUHAZID=? and RAKTAR.TERMEKTIPUS like 'konyv' and RAKTAR.TERMEKID=KONYV.ID");
			s.setInt(1, aruhazId);
			ResultSet rs=s.executeQuery();
			try{
				while(rs.next()){
					list.add(new Konyv(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
							rs.getString(10), rs.getString(11),rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getBoolean(15), rs.getBoolean(16), rs.getInt(17)));
				}
			}finally{
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Lekér egy könyvet id alapján
	 * @param konyvId
	 * @return
	 */
	public static Konyv getKonyvIdSzerint(int konyvId){
		Konyv konyv=null;
		try {
			PreparedStatement s=KonyvesboltDao.createPreparedStatement("SELECT "
					+ "ID,CIM, OLDALSZAM, KIADIDO, HANYADIKKIADAS, SZERZO, TARSSZERZO, KIADO, VASARLASSZAM, MERET, KOTES, AR, MUFAJ, ALMUFAJ, EBOOK,CSAKEB, ISBN13"
					+ " FROM KONYV where ID=?");
			s.setInt(1, konyvId);
			ResultSet rs=s.executeQuery();
			try{
				if(rs.next()){
					konyv=new Konyv(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
							rs.getString(10), rs.getString(11),rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getBoolean(15), rs.getBoolean(16), rs.getInt(17));
				}
			}finally{
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return konyv;
	}
}
