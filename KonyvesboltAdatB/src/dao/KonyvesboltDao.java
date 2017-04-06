package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class KonyvesboltDao {
	private OracleDataSource ods;
	private Connection conn;
	public KonyvesboltDao(String username,String password) throws SQLException{
			ods = new OracleDataSource(); 
		    try {
				Class.forName ("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		    ods.setURL("jdbc:oracle:thin:@localhost:1521:kabinet"); 
		    conn = ods.getConnection(username,password); 
	}
	public Statement createStatement() throws SQLException{
		return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_READ_ONLY);
	}
}
