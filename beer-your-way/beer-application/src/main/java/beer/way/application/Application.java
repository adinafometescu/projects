package beer.way.application;

import beer.way.application.config.LocaleConfig;
import beer.way.application.config.WebSecurityConfig;
import beer.way.product.ProductConfig;
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