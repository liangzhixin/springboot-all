package com.example.springbootall.datasource;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 *  Druid连接池+多数据源+Mybatis+Atomikos(springboot分布式事务)
 */
@Configuration
@MapperScan(basePackages = {"com.example.springbootall.mapper.cluster"},
        sqlSessionTemplateRef = "twoSqlSessionTemplate")
public class TwoDruidDataSourceConfig {

    @Value("${spring.datasource.cluster.url}")
    private String url;

    @Value("${spring.datasource.cluster.username}")
    private String username;

    @Value("${spring.datasource.cluster.password}")
    private String password;

    @Value("${spring.datasource.cluster.driver-class-name}")
    private String driverClassName;

    @Value("${druid.initialSize}")
    private String initialSize;

    @Value("${druid.minIdle}")
    private String minIdle;

    @Value("${druid.maxActive}")
    private String maxActive;

    @Value("${druid.maxWait}")
    private String maxWait;

    @Value("${mybatis.cluster.mapper-locations}")
    private String mapperLocation;

    @Bean(name="twoDataSource")
    public DataSource masterDataSource(){
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl(url);
        druidXADataSource.setUsername(username);
        druidXADataSource.setPassword(password);
        druidXADataSource.setDriverClassName(driverClassName);
        druidXADataSource.setInitialSize(Integer.parseInt(initialSize));
        druidXADataSource.setMinIdle(Integer.parseInt(minIdle));
        druidXADataSource.setMaxActive(Integer.parseInt(maxActive));
        druidXADataSource.setMaxWait(Long.parseLong(maxWait));

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("twoDataSource");
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);

        return atomikosDataSourceBean;
    }

    @Bean(name="twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="twoSqlSessionTemplate")
    public SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
