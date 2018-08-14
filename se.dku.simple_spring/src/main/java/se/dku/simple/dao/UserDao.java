package se.dku.simple.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	// 수정자 메소드 DI 방식을 사용한 UserDao (아래의 생성자 파라미터 방식 대신 사용)
	public void setConnectionMaker(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	/*
	// 생성자
	// (1.3.3 관계설정책임의분리) connection에 대한 종속성을 분리하기 위해 생성자에 파라미터 작성한다.
	public UserDao(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	*/
	
	/* DaoFactory를 이용하는 UserDao 생성자::메소드나 생성자를 통한 주입 대신 스스로 컨테이너(여기선 DaoFactory)에게 요청하는 방법(의존관계 검색) (비추)
	 * public UserDao(){
	 * 	DaoFactory daoFactory = new DaoFactory();
	 * 	this.connectionMaker = daoFactory.connectionMaker();
	 * }
	 */
	
	/* Application Context의 getBean()메소드를 이용한 의존관계 검색 (UserDao의 생성자) (비추)
	 * public UserDao(){
	 * 	ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
	 * 	this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
	 * }
	 */
	
	
	
	// 새로운 사용자를 생성하는 메소드
	public void add(User user) throws ClassNotFoundException, SQLException {
		
		// 문제O -> 분리 필요한 코드
		// UserDao에서 어떤 ConnectionMaker 구현 클래스를 사용할지를 결정하는 관심사를 가지고 있음
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement(
				"insert into users(id, name, password) values(?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}

	// id를 통해 사용자 정보를 읽어오는 메소드
	public User get(String id) throws ClassNotFoundException, SQLException {
		
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement(
				"select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id")); // id, name, password 대신 1,2,3 써도 ok
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
}
