package com.example.ResearchGate.config;

import com.example.ResearchGate.filter.AuthenticFilter;
import com.example.ResearchGate.filter.StudentFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<AuthenticFilter> authenticFilterFilterRegistrationBean(){
        FilterRegistrationBean<AuthenticFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticFilter());
        registrationBean.addUrlPatterns("/home", "/", "/student", "/student/updateInfo");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<StudentFilter> studentFilterFilterRegistrationBean(){
        FilterRegistrationBean<StudentFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new StudentFilter());
        registrationBean.addUrlPatterns("/student", "/student/updateInfo");
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
