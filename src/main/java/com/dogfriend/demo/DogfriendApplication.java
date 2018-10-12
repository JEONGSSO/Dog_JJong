package com.dogfriend.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication	
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})	//1008 톰캣 안켜있는데 켜있다할때 넣음 그래도 안되면 componentscan잠시 주석후 껐다가 다시 주석 풀기
@ComponentScan("com.dogfriend")
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
