package com.powernode.beans.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author wataxi @Date 2023/9/26 21:01 @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.powernode.beans"},
    excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
    })
public class Spring6Config {}

