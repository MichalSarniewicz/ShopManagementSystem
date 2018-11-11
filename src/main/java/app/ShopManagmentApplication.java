package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import configuration.SecurityConfig;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"controller"})
@ComponentScan(basePackageClasses = SecurityConfig.class)
@EnableJpaRepositories(basePackages= {"repository"})
@EntityScan("model")

public class ShopManagmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopManagmentApplication.class, args);
	}
}