package se.dku.simple.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import javax.sql.DataSource;

// 팩토리 역할을 할 클래스
// @Configuration: 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {
	// @Bean: 객체 생성을 담당하는 IoC용 메소드라는 표시
	@Bean
	public UserDao userDao(){
		// 수정자 메소드 DI 방식 사용을 위해 세 줄 추가
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
		// return new UserDao(connectionMaker());
	}
	
	/* DAO를 하나 더 만든다면...이런 식으로
	public AccountDao accountDao(){
		return new AccountDao(connectionMaker());
	}
	 */
	
	@Bean
	public DataSource dataSource(){
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		// SimpleDriverDataSource 클래스는 DataSource 인터페이스의 구현 클래스이다.
		
		dataSource.setDriverClass(org.mariadb.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mariadb://localhost:3306/dao_test0803");
		dataSource.setUsername("root");
		dataSource.setPassword("pass");
		
		return dataSource;
	}
	
	
	
	/* (1.8.3) DataSource 사용 위해 connectionMaker() 메소드를 dataSource() 메소드로 대체한다.
	// (1.4.2) ConnectionMaker 구현 클래스를 무엇을 사용할지를 결정하는 코드를 별도의 메소드로 분리해서 만든 것(for DAO마다 중복을 피하기 위함)
	// (1.8.1) 여기서 connectionMaker()에 해당하는 빈은 의존하는 다른 오브젝트는 없다.
	@Bean
	public ConnectionMaker connectionMaker(){
		// ConnectionMaker 구현 클래스 중 어떤 것을 사용할지 결정 (여기선 NConnectionMaker로 선정한 것)
		
		// 예전 코드
		// ConnectionMaker connectionMaker = new NConnectionMaker();
		// return connectionMaker;
		
		
		return new NConnectionMaker();
	}
	*/
}
