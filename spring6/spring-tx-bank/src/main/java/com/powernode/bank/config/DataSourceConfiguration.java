package com.powernode.bank.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author wataxi @Date 2023/9/27 18:17 @Version 1.0
 */
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
  @Value("${jdbc.url}")
  private String url;

  @Value("${jdbc.username}")
  private String username;

  @Value("${jdbc.password}")
  private String password;

  @Bean
  public DataSource getDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUrl(this.url);
    dataSource.setUsername(this.username);
    dataSource.setPassword(this.password);
    return dataSource;
  }
}
