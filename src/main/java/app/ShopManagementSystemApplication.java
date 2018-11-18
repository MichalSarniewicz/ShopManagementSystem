package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import configuration.SecurityConfig;

/**
 * Main class of the Spring Boot aplication Shop Management System.
 * This app has been created to manage products, orders, deliveries and suppliers. 
 * You can easily filter results and go to other related data.
 * Everything is based on Spring Boot, Security and Database combined with the CrudRepository.
 *
 * The application and new features are still being developed.
 * 
 * @author Michał Sarniewicz
 *
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"controller"})
@ComponentScan(basePackageClasses = SecurityConfig.class)
@EnableJpaRepositories(basePackages= {"repository"})
@EntityScan("model")

public class ShopManagementSystemApplication {
	
	/**
	 * Main method which runs Spring Boot Aplication.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ShopManagementSystemApplication.class, args);
	}
}