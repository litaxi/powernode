package com.powernode.bank.config;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author wataxi @Date 2023/9/28 0:49 @Version 1.0
 */
@Configuration
@ComponentScan("com.powernode.bank")
@Import(DataSourceConfig.class)
@MapperScan("com.powernode.bank.mapper")
@EnableTransactionManagement
public class BankConfig {

  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean(
      DataSource dataSource, ApplicationContext applicationContext) {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setConfigLocation(applicationContext.getResource("mybatis-config.xml"));
    factoryBean.setDataSource(dataSource);
    factoryBean.setTypeAliasesPackage("com.powernode.bank.pojo");
    return factoryBean;
  }

  @Bean
  public TransactionManager transactionManager(DataSource dataSource){
    return new DataSourceTransactionManager(dataSource);
  }

}
