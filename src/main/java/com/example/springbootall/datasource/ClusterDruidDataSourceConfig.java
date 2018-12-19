package com.example.springbootall.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 *  Druid连接池+多数据源+Mybatis
 */
//@Configuration
//@MapperScan(basePackages = {"com.example.springbootall.mapper.cluster"},
//        sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDruidDataSourceConfig {

    @Value("${spring.datasource.cluster.url}")
    private String url;

    @Value("${spring.datasource.cluster.username}")
    private String username;

    @Value("${spring.datasource.cluster.password}")
    private String password;

    @Value("${spring.datasource.cluster.driver-class-name}")
    private String driverClassName;

    @Value("${mybatis.cluster.mapper-locations}")
    private String mapperLocation;

    @Value("${druid.initialSize}")
    private String initialSize;

    @Value("${druid.minIdle}")
    private String minIdle;

    @Value("${druid.maxActive}")
    private String maxActive;

    @Value("${druid.maxWait}")
    private String maxWait;

    @Bean(name="clusterDataSource")
    public DataSource clusterDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(Integer.parseInt(initialSize));
        dataSource.setMinIdle(Integer.parseInt(minIdle));
        dataSource.setMaxActive(Integer.parseInt(maxActive));
        dataSource.setMaxWait(Long.parseLong(maxWait));
        return dataSource;
    }

    @Bean(name="clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("clusterDataSource") DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
