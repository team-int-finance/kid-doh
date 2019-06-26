package com.dmarchante.kiddoh.config;

import com.dmarchante.kiddoh.implementations.DashboardDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class BeanConfig {
    @Bean
    public DashboardDao createBean() {
        DashboardDao bean = new DashboardDao() {
            @Override
            public List<List<Map<Object, Object>>> getDashboardData() {
                return null;
            }
        };
        return bean;
    }
}

//@Configuration
//public MyConfigurationClass {
//    @Bean(name="someBeanName")
//    public MyInterface createBean() {
//        MyInterface bean = new Myclass();
//        return bean;
//    }
//}
