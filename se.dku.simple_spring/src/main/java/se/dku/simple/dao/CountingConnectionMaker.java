package se.dku.simple.dao;

import java.sql.Connection;
import java.sql.SQLException;

// DB연결 횟수 카운팅 기능이 있는 클래스
// DAO가 의존할 대상이어야 하기 때문에 ConnectionMaker인터페이스를 상속받았다.
public class CountingConnectionMaker implements ConnectionMaker{
	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker){
		this.realConnectionMaker = realConnectionMaker;
	}
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException{
		this.counter++; // DB 연결 횟수 count
		return realConnectionMaker.makeConnection(); // 실제 DB 연결
	}
	
	public int getCount(){
		return this.counter;
	}
}
