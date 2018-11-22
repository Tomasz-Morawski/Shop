package org.psyduck.Shop.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Value("${database.driver.className:org.h2.Driver}")//do ew zmiany bo h2 udostępnia też postgress
    private String driverClassName;

    @Value("${database.connection.url:jdbc:h2:~/test}")
    private String connectionUrl;
    @Value("${database.connection.username:sa")
    private String userName;

    @Value("${database.connection.userPassword:sa")
    private String userPassword;

    @Value("${database.connection.hDialect:org.hibernate.dialect.H2Dialect")
    private String hibernateDialect;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("org.psyduck.Shop.domain");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        return em;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource= new DriverManagerDataSource(connectionUrl, userName, userPassword);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
