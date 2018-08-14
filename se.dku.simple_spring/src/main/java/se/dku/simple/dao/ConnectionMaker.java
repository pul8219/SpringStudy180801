package se.dku.simple.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// DB 연결 기능을 따로 클래스를 만들어 메소드 내에 포함시킨 것(1.3.1 클래스의 분리)
// UserDao와 종속성을 없애기 위하여 인터페이스로 만듦(1.3.2 인터페이스의 도입)

public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
