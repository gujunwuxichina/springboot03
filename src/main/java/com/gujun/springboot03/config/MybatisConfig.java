package com.gujun.springboot03.config;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MybatisConfig {

    //配置MapperScannerConfigurer来通过扫描来装配Mybatis所需组件；
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
//        //此处的SqlSessionFactory，是由SpringBoot自动产生的；
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        //定义扫描的包范围
        mapperScannerConfigurer.setBasePackage("com.gujun.springboot03.dao");
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        return mapperScannerConfigurer;
    }

}
