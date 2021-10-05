package com.bandtec.mais.consulta.infra.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
public class DataSourceConfig {

//
//    @Value("${database.url}")
//    String URL;
//
//    @Value("${database.username}")
//    String USERNAME;
//
//    @Value("${database.password}")
//    String PASSWORD;
//
//    @Value("${database.driver}")
//    String DRIVER;
//
//    @Value("${database.schema}")
//    String DATABASE;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setSchema(DATABASE);
//        dataSource.setCatalog(DATABASE);
//        dataSource.setDriverClassName(DRIVER);
//        dataSource.setUrl(URL);
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//
//        return dataSource;
//    }
//
//    @Bean
//    public Properties additionalProperties() {
//        Properties props = new Properties();
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "update");
//
//        return props;
//    }

}
