package com.PizzaHut;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PizzaHutApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaHutApplication.class, args);
	}
	@Bean //Indicates that a method produces a bean to be managed by the Spring container
	public ModelMapper myMapper()
	{
		//create model mapper instance 
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}
}
