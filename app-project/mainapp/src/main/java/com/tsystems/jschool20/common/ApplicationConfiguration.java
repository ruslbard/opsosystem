package com.tsystems.jschool20.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by ruslbard on 27.03.2017.
 */
@Configuration
@EnableJpaRepositories()
public class ApplicationConfiguration {

    @Bean
    public DataSource dataSourceProd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.oracle.jdbc.Driver");
        dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:OPSOSYS");
        dataSource.setUsername("OPSOSYSTEM");
        dataSource.setPassword("opsos");
        return dataSource;
    }
}
