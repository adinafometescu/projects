package com.project.byw;

import beer.way.product.ProductConfig;
import com.project.byw.config.LocaleConfig;
import com.project.byw.config.WebSecurityConfig;
import login.LoginConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebSecurityConfig.class, LoginConfiguration.class, LocaleConfig.class, ProductConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}