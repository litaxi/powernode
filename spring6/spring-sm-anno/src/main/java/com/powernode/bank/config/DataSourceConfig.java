package com.powernode.bank.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author wataxi @Date 2023/9/28 1:04 @Version 1.0
 */
@Component
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.username}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  @Bean
  public DataSource dataSource(){
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setUrl(this.url);
    druidDataSource.setUsername(this.username);
    druidDataSource.setPassword(this.password);
    return druidDataSource;
  }

}
