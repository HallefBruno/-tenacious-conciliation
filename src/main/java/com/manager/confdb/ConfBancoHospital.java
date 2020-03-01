package com.manager.confdb;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "hospitalEntityManagerFactory",
        transactionManagerRef = "hospitalTransactionManager",
        basePackages = { "com.manager.repository.hospital" }
)
public class ConfBancoHospital {
	
	@Primary
    @Bean(name = "hospitalDataSource")
    @ConfigurationProperties(prefix = "spring.hospital.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Primary
    @Bean(name = "hospitalEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("hospitalDataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<>();
        return builder
                .dataSource(dataSource)
                .packages("com.manager.entity.hospital")
                .properties(properties)
                .build();
    }
	
	@Primary
    @Bean(name = "hospitalTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("hospitalEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}