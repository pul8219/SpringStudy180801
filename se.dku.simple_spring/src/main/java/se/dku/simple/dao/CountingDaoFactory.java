package se.dku.simple.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// CountingConnectionMaker 클래스로 인해 생겨난 새로운 의존관계 적용을 위한 설정용 클래스
@Configuration
public class CountingDaoFactory {
	
	@Bean
	public UserDao userDao(){
		// 수정자 메소드 DI 방식 사용을 위해 세 줄 추가s
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
		// return new UserDao(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker(){
		return new CountingConnectionMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker(){
		return new NConnectionMaker();
	}
	
}
