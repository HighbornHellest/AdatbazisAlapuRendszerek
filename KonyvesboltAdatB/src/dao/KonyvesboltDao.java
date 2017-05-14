package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import oracle.jdbc.pool.OracleDataSource;

/**
 * @author Tamássy Urmás
 *
 */
public class KonyvesboltDao {
	public static final String TERMEK_TIPUS_KONYV="konyv";
	public static final String TERMEK_TIPUS_FILM="film";
	public static final String TERMEK_TIPUS_ALBUM="album";
	
	private static OracleDataSource ods;
	private static Connection conn;
	/**
	 * Megnyitja a kapcsolatot az adatbázissal
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static Connection connect(String username,String password) throws SQLException{
			ods = new OracleDataSource(); 
		    try {
				Class.forName ("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		    //jdbc:oracle:thin:@localhost:1521:kabinet
		    //jdbc:oracle:thin:@orania.inf.u-szeged.hu:1521:kabinet
		    ods.setURL("jdbc:oracle:thin:@localhost:1521:kabinet");
		    conn = ods.getConnection(username,password);
		    Statement s=createStatement();
		    try{
		    	s.executeQuery("ALTER SESSION SET CURRENT_SCHEMA = H670182");
		    }finally{
		    	s.close();
		    }
		    return conn;
	}
	/**
	 * Lezárja a kapcsolatot.
	 * @throws SQLException
	 */
	public static void disconnect() throws SQLException{
		conn.close();
	}
	/**
	 * Dao műveletekhez szükséges segédfüggvény
	 * @return
	 * @throws SQLException
	 */
	public static Statement createStatement() throws SQLException{
		Statement s=null;
		if(!Objects.equals(conn, null)){
			s=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_READ_ONLY);
		}
		return s;
	}
	/**
	 * Dao műveletekhez szükséges segédfüggvény
	 * @param sql
	 * @param generatedKeys
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement createPreparedStatement(String sql,String[] generatedKeys) throws SQLException{
		PreparedStatement s=null;
		if(!Objects.equals(conn, null)){
			s=conn.prepareStatement(sql,generatedKeys);
		}
		return s;
	}
	/**
	 * Dao műveletekhez szükséges segédfüggvény
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement createPreparedStatement(String sql) throws SQLException{
		PreparedStatement s=null;
		if(!Objects.equals(conn, null)){
			s=conn.prepareStatement(sql);
		}
		return s;
	}
	
}
