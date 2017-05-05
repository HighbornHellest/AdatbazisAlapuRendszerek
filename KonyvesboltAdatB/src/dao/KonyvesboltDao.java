package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import oracle.jdbc.pool.OracleDataSource;

public class KonyvesboltDao {
	public static final String TERMEK_TIPUS_KONYV="konyv";
	public static final String TERMEK_TIPUS_FILM="film";
	public static final String TERMEK_TIPUS_ALBUM="album";
	
	private static OracleDataSource ods;
	private static Connection conn;
	public static Connection connect(String username,String password) throws SQLException{
			ods = new OracleDataSource(); 
		    try {
				Class.forName ("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		    ods.setURL("jdbc:oracle:thin:@localhost:1521:kabinet");
		    conn = ods.getConnection(username,password);
		    Statement s=createStatement();
		    try{
		    	s.executeQuery("alter session set current_schema=h670182");
		    }finally{
		    	s.close();
		    }
		    return conn;
	}
	public static void disconnect() throws SQLException{
		conn.close();
	}
	public static Statement createStatement() throws SQLException{
		Statement s=null;
		if(!Objects.equals(conn, null)){
			s=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_READ_ONLY);
		}
		return s;
	}
	public static PreparedStatement createPreparedStatement(String sql,String[] generatedKeys) throws SQLException{
		PreparedStatement s=null;
		if(!Objects.equals(conn, null)){
			s=conn.prepareStatement(sql,generatedKeys);
		}
		return s;
	}
	public static PreparedStatement createPreparedStatement(String sql) throws SQLException{
		PreparedStatement s=null;
		if(!Objects.equals(conn, null)){
			s=conn.prepareStatement(sql);
		}
		return s;
	}
	
}
