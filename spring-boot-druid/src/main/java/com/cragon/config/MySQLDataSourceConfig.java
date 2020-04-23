package com.cragon.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:mysql.properties")
@MapperScan(basePackages = MySQLDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSessionFactory")
public class MySQLDataSourceConfig {
    // DAO扫描路径
    static final String PACKAGE = "com.cragon.mysql.dao";
    // Mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/mysql/*.xml";

//    @Primary
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTransactionManager")
//    @Primary
    public DataSourceTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(mysqlDataSource());
    }

    @Bean(name = "mysqlSessionFactory")
//    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setDataSource(mysqlDataSource());
        factory.setMapperLocations(resolver.getResources(MySQLDataSourceConfig.MAPPER_LOCATION));

        return factory.getObject();
    }
}
