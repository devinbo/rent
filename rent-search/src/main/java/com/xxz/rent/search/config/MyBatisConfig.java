package com.xxz.rent.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.xxz.rent.mapper","com.xxz.rent.search.dao"})
public class MyBatisConfig {
}
