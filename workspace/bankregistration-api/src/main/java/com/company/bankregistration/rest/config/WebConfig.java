package com.company.bankregistration.rest.config;

import com.atomic32.logging.web.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

  @Bean
  public FilterRegistrationBean<LoggingFilter> loggingFilterRegistration() {

    FilterRegistrationBean<LoggingFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(createLoggingFilter());
    registration.addUrlPatterns("/*");
    registration.setName("loggingFilter");
    registration.setOrder(1);
    return registration;
  }

  public LoggingFilter createLoggingFilter() {
    return new LoggingFilter();
  }
}
