package com.tsystems.jschool20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.tsystems.jschool20.srvengine.repos")
public class ApplicationConfiguration {


    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dmDS = new DriverManagerDataSource();
        dmDS.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dmDS.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:OPSOSYS");
        dmDS.setUsername("OPSYSTEM");
        dmDS.setPassword("opsys");
        return dmDS;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter(){

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.ORACLE);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        return vendorAdapter;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, HibernateJpaVendorAdapter vendorAdapter){

        LocalContainerEntityManagerFactoryBean localFactory = new LocalContainerEntityManagerFactoryBean();
        localFactory.setJpaVendorAdapter(vendorAdapter);
        localFactory.setDataSource(dataSource);
        localFactory.setPackagesToScan("com.tsystems.jschool20.srvengine.entities");
        localFactory.afterPropertiesSet();

        return localFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory(dataSource(), hibernateJpaVendorAdapter()));
        return txManager;
    }
}
