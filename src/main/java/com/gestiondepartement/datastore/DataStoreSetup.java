package com.gestiondepartement.datastore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages= {"com.gestiondepartement.Repository"})
@ComponentScan(value= "com.gestiondepartement.*")
@EntityScan(basePackages= {"com.gestiondepartement.Entity"})
public class DataStoreSetup {
    @Value("${spring.datasource.url}")
    String databaseUrl;
    @Value ("${spring.datasource.username}")
    String databaseUser;
    @Value ("${spring.datasource.password}")
    String databasePassWord;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databasePassWord);
        return dataSource;
    }
}
