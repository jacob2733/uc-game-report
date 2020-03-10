package com.uchuang.gamereport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import stone.dal.adaptor.spring.common.annotation.EnableSequence;
import stone.dal.adaptor.spring.jdbc.annotation.StJpaRepositoryScan;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.uchuang.gamereport.jpa")
@EnableSequence(storePath = ".")
@StJpaRepositoryScan("com.uchuang.gamereport.repo")
@ComponentScan(basePackages = { "com.uchuang.gamereport.controller", "com.uchuang.gamereport.config" })
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setMaxFileSize("500MB");
    factory.setMaxRequestSize("500MB");
    return factory.createMultipartConfig();
  }

}

