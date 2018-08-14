package se.dku.simple.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao1 = context.getBean("userDao", UserDao.class);
		UserDao dao2 = context.getBean("userDao", UserDao.class);
		
		System.out.println(dao1);
		System.out.println(dao2);
	}
}
