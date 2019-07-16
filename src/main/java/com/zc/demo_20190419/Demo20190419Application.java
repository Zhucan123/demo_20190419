package com.zc.demo_20190419;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Properties;

@SpringBootApplication
@MapperScan("com.zc.demo_20190419.domain.repository")
public class Demo20190419Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo20190419Application.class, args);
    }


    //配置mybatis的分页插件pageHelper
     @Bean
     public PageHelper pageHelper(){
                 PageHelper pageHelper = new PageHelper();
                 Properties properties = new Properties();
                 properties.setProperty("offsetAsPageNum","true");
                 properties.setProperty("rowBoundsWithCount","true");
                 properties.setProperty("reasonable","true");
                 properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
                 pageHelper.setProperties(properties);
                 return pageHelper;
             }

}
