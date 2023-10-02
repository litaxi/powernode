package com.powernode.bank.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author wataxi @Date 2023/9/27 17:43 @Version 1.0
 */
@Configuration
@ComponentScan("com.powernode.bank")
//@ComponentScan({"com.powernode.bank.service", "com.powernode.bank.dao"})
@PropertySource("classpath:jdbc.properties")
@Import(DataSourceConfiguration.class)
@EnableTransactionManagement
public class Spring6config {

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  @Bean
  public TransactionManager transactionManager(DataSource dataSource){
    return new DataSourceTransactionManager(dataSource);
  }
}
