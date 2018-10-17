/**
 *  定时任务
 *  cron表达式详细用法见http://www.cnblogs.com/canger/p/6046771.html
 *  在线cron表达式生成器见http://www.pdtools.net/tools/becron.jsp#cron
 */
 
 
 
/**
 *  配置Druid连接池+多数据源+Mybatis
 *  1.只整合Mybatis时,我们只需要在配置文件配置相关属性,springboot会自动生成默认的dataSource,sqlSessionFactory,transactionManager
 *  2.配置Druid连接池时,我们要使用的是Druid的数据源而不是默认的数据源,所以需要我们自己去配置dataSource,sqlSessionFactory,transactionManager
 *  3.配置多数据源时,也需要我们自己去配置
 */
 
 
 
  数据库连接池的作用详见https://blog.csdn.net/u011225629/article/details/48317919
  
  
  
  注意: @Transactional注解可以注解在类上或方法上,但只对public方法有效
  
  
  
  