package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import configuration.SecurityConfig;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackageClasses = controller.MainController.class)
@ComponentScan(basePackageClasses = SecurityConfig.class)
@ComponentScan(basePackageClasses = app.OrderDetailsRepository.class)
@ComponentScan(basePackageClasses = app.SupplierRepository.class)

public class ShopManagmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopManagmentApplication.class, args);
	}
}
