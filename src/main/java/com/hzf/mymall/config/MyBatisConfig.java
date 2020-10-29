package com.hzf.mymall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.hzf.mymall.mapper","com.hzf.mymall.dao"})
public class MyBatisConfig {
}
