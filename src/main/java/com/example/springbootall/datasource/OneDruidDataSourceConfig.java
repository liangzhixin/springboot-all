package com.example.springbootall.datasource;

import com.alibaba.druid.pool.DruidDataSource;
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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 *  Druid连接池+多数据源+Mybatis+Atomikos(springboot分布式事务)
 */
@Configuration
@MapperScan(basePackages = {"com.example.springbootall.mapper.master"},
        sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class OneDruidDataSourceConfig {

    @Value("${spring.datasource.master.url}")
    private String url;

    @Value("${spring.datasource.master.username}")
    private String username;

    @Value("${spring.datasource.master.password}")
    private String password;

    @Value("${spring.datasource.master.driver-class-name}")
    private String driverClassName;

    @Value("${druid.initialSize}")
    private String initialSize;

    @Value("${druid.minIdle}")
    private String minIdle;

    @Value("${druid.maxActive}")
    private String maxActive;

    @Value("${druid.maxWait}")
    private String maxWait;

    @Value("${mybatis.master.mapper-locations}")
    private String mapperLocation;

    @Primary
    @Bean(name="oneDataSource")
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
        atomikosDataSourceBean.setUniqueResourceName("oneDataSource");
        atomikosDataSourceBean.setXaDataSource(druidXADataSource);

        return atomikosDataSourceBean;
    }

    @Primary
    @Bean(name="oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name="oneSqlSessionTemplate")
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
