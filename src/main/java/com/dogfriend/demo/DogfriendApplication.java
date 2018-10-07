package com.dogfriend.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude=	//1008 톰캣 안켜있는데 켜있다할때 넣음
						 {DataSourceAutoConfiguration.class})
@SpringBootApplication	
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
