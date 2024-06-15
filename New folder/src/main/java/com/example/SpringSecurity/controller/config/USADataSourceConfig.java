package com.example.SpringSecurity.controller.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("usa")
public class USADataSourceConfig {
	@Value("${usa.datasource.url}")
	private String url;
	@Value("${usa.datasource.username}")
	private String username;
	@Value("${usa.datasource.password}")
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


//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    @Profile("usa")
//    public DataSource dataSourceDevelopment() {
//        // Configuration for development environment
//    }
//
//    @Bean
//    @Profile("europe")
//    public DataSource dataSourceProduction() {
//        // Configuration for production environment
//    }
//}


//@Configuration
//@PropertySource(value = "application-usa.properties", ignoreResourceNotFound = true)
//public class AppConfig {
//

//}







