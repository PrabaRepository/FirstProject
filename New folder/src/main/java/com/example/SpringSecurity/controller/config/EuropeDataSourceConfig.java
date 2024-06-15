package com.example.SpringSecurity.controller.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("europe")
public class EuropeDataSourceConfig {

	@Value("${europe.datasource.url}")
	private String url;
	@Value("${europe.datasource.username}")
	private String username;
	@Value("${europe.datasource.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
