package com.bandtec.maisconsulta.infra.database

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import java.util.*
import javax.sql.DataSource

@Configuration
class DataSourceConfig {
    @Value("\${database.url}")
    var URL: String? = null

    @Value("\${database.username}")
    var USERNAME: String? = null

    @Value("\${database.password}")
    var PASSWORD: String? = null

    @Value("\${database.driver}")
    var DRIVER: String? = null

    @Value("\${database.schema}")
    var DATABASE: String? = null

    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.schema = DATABASE
        dataSource.catalog = DATABASE
        dataSource.setDriverClassName(DRIVER!!)
        dataSource.url = URL
        dataSource.username = USERNAME
        dataSource.password = PASSWORD
        return dataSource
    }

    // Define o hibernate como implementacao do JPA
    @Bean
    fun additionalProperties(): Properties {
        val props = Properties()
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect")
        props.setProperty("hibernate.show_sql", "true")
        props.setProperty("hibernate.hbm2ddl.auto", "update")
        return props
    }
}