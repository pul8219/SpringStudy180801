/*

package se.dku.simple.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// CountingConnectionMaker와 CountingDaoFactory 클래스를 테스트하는 클래스
public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("lueur_yrs2");
		user.setName("Park-Yurim");
		user.setPassword("1234");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공!\n");
		
		User user2 = new User();
		user2 = dao.get(user.getId());
		System.out.println("ID: " + user2.getId());
		System.out.println("이름: " + user2.getName());
		System.out.println("PW: " + user2.getPassword());
		
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter: " + ccm.getCount());
		
	}
}

*/