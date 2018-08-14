package se.dku.simple.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker{
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("org.mariadb.jdbc.Driver");
		// DB연결
		// getConnection(위치, DB 아이디, DB 패스워드)
		Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/dao_test0803", "root", "pass");
		return c;
	
	}
}
