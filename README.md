/**
 *  定时任务
 *  cron表达式详细用法见http://www.cnblogs.com/canger/p/6046771.html
 *  在线cron表达式生成器见http://www.pdtools.net/tools/becron.jsp#cron
 */
 
  
  
  SpringBoot事务:
      springboot会自动创建DataSourceTransactionManager(查看DataSourceTransactionManagerAutoConfiguration源码)
      springboot会自动创建SqlSessionFactory(查看MybatisAutoConfiguration源码)
      在springboot中已经默认对jpa、jdbc、mybatis开启了事务，引入它们依赖的时候，事务就默认开启(查看TransactionAutoConfiguration源码)
      因此使用事务只需要添加@Transactional注解。
      但要注意: 
        1.@Transactional注解可以注解在类上或方法上,但只对public方法有效
        2.只有目标方法由外部调用，才能被 Spring 的事务拦截器拦截。在同一个类中的两个方法直接调用，是不会被 Spring 的事务拦截器拦截的
        3.要想本类调用事务方法生效，操作如下：
            主类添加注解@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
                或配置文件添加<aop:aspectj-autoproxy proxy-target-class="true" expose-proxy="true"/>
            在xxxServiceImpl中，用(xxxService)(AopContext.currentProxy())，获取到xxxService的代理类，再调用事务方法，强行经过代理类，激活事务切面
           
                         
                
  
      
  
  
  
  
  
  
  
  
  
  
  
  
  