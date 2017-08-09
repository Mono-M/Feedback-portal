package com.dubinin.feedbackportal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Vladyslav_Dubinin on 7/8/2017.
 */
@Configuration
@EnableTransactionManagement
public class RepositoryConfiguration {
    private static final String[] PACKAGES_TO_SCAN = {"com.dubinin.feedbackportal.entity"};
    private static final String HIBERNATE_HBM2DDL_AUTO_KEY = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_DIALECT_KEY = "hibernate.dialect";
    private static final String SPRING_JPA_HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME = "spring.jpa.hibernate.hbm2ddl.auto";
    private static final String SPRING_JPA_DATABASE_PLATFORM_PROPERTY_NAME = "spring.jpa.database-platform";
    private static final String SPRING_DB_USERNAME_PROPERTY_NAME = "spring.db.username";
    private static final String SPRING_DB_PASSWORD_PROPERTY_NAME = "spring.db.password";
    private static final String SPRING_DB_URL_PROPERTY_NAME = "spring.db.url";
    private static final String SPRING_DB_DRIVER_CLASS_NAME_PROPERTY_NAME = "spring.db.driverClassName";

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(SPRING_DB_DRIVER_CLASS_NAME_PROPERTY_NAME));
        dataSource.setUrl(env.getProperty(SPRING_DB_URL_PROPERTY_NAME));
        dataSource.setUsername(env.getProperty(SPRING_DB_USERNAME_PROPERTY_NAME));
        dataSource.setPassword(env.getProperty(SPRING_DB_PASSWORD_PROPERTY_NAME));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        final Properties jpaProperties = new Properties();
        jpaProperties.setProperty(HIBERNATE_HBM2DDL_AUTO_KEY, env.getProperty(SPRING_JPA_HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME));
        jpaProperties.setProperty(HIBERNATE_DIALECT_KEY, env.getProperty(SPRING_JPA_DATABASE_PLATFORM_PROPERTY_NAME));
        factoryBean.setJpaProperties(jpaProperties);

        return factoryBean;
    }
}
