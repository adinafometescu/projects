package com.project.byw;

import com.project.byw.product.ProductConfig;
import com.project.byw.config.LocaleConfig;
import com.project.byw.config.WebSecurityConfig;
import com.project.location.LocationConfig;
import com.project.login.LoginConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebSecurityConfig.class, LoginConfiguration.class, LocaleConfig.class, ProductConfig.class, LocationConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}