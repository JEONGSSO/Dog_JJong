package com.dogfriend.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@Configuration @EnableConfiguration @ComponentScan 포함하는 어노테이션
@SpringBootApplication	
//자동 설정을 담당 exclude는 제외
// DB 설정을 넣고, 맞는 드라이버와 라이브러리 설치, JDBC 설정을 해야하는데 아직은 비어있으니 제외.
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})	//1008 톰캣 안켜있는데 켜있다할때 넣음 그래도 안되면 componentscan잠시 주석후 껐다가 다시 주석 풀기
@ComponentScan("com.dogfriend") //com.dogfriend 밑의 패키지들 bean을 자동 등록
public class DogfriendApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(DogfriendApplication.class, args);
	}

	/*
     * SqlSessionFactory 설정 
   
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
        
    }
      */
}
