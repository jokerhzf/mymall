package com.hzf.mymall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：MyBatis配置类
 */
@Configuration
@MapperScan("com.macro.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
