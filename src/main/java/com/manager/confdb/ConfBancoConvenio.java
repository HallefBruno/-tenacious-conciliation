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
        entityManagerFactoryRef = "convenioEntityManagerFactory",
        transactionManagerRef = "convenioTransactionManager",
        basePackages = { "com.manager.repository.convenio" }
)
public class ConfBancoConvenio {
	
	//@Primary
    @Bean(name = "convenioDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
	//@Primary
    @Bean(name = "convenioEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("convenioDataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<>();
        return builder
                .dataSource(dataSource)
                .packages("com.manager.entity.convenio")
                .properties(properties)
                .build();
    }
	
	//@Primary
    @Bean(name = "convenioTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("convenioEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
