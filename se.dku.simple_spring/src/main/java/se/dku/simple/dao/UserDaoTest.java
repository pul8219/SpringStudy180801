package se.dku.simple.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		// xml 파일을 읽어들이도록
		ApplicationContext context = new GenericXmlApplicationContext("se/dku/simple/dao/applicationContext.xml");
		
		// 애플리케이션 컨텍스트 사용한 것
		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		//UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("pul8219");
		user.setName("박유림");
		user.setPassword("1234");
		
		dao.add(user);
		
		System.out.println(user.getId()+"등록 성공!");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId()+"조회 성공!");
	}
}
