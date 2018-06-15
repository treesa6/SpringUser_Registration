package com.treesaSunny.registration;

import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.jdbc.core.JdbcTemplate;

/*
 * The spring boot application containing the main classS
 */
@SpringBootApplication
public class RegisterNewUsersApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(RegisterNewUsersApplication.class);
	
	@Autowired
	DataSource dataSource;
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SpringRootConfigRespository userRepository;	
	public static void main(String[] args) {
		SpringApplication.run(RegisterNewUsersApplication.class, args);
		
		//obj.dataSource();
		//obj.testFindAllUserDetailss();
		//obj.testFindAllUserDetailss();
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
	   return new JdbcTemplate(dataSource);
	}
	 
	
	@Override
	public void run(String... args) throws Exception {
		 System.out.println("Our DataSource is = " + dataSource);
		  
		
	}
	
	    
	
}
