package configuration;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;





@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        PasswordEncoder delegatingPasswordEncoder =
        	    PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
        .passwordEncoder(delegatingPasswordEncoder)
        .withUser("admin").password("{bcrypt}$2a$04$0X9TeVhmFhkA3ZsOISAF2OFSTmUaEqsWsJcR.acdNgkHK4QYuNFmW").roles("ADMIN")//admin admin
        //generate hashes with $2a$, only this way it works, https://www.dailycred.com/article/bcrypt-calculator
        
        .and()
        
        .withUser("user").password("{bcrypt}$2a$04$snWCTLfoZ9qa5bTH.68.Qeet8/RobbVOBmhYy8tGBM2Br/HqTw6Gy")//user user
        .roles("USER");
    }
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated() 
            .and()
          .formLogin()
            .loginPage("/login")
            .permitAll()
            .failureUrl("/login?message=error")
          .and()
            .logout()
            .logoutSuccessUrl("/login?message=logout")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .permitAll()
        .and()
        	.httpBasic()
        .and()
        .authorizeRequests()
        	.antMatchers("/css/**", "/js/**", "/images/**", "/h2_console/**", "/h2_console/**")
        	.permitAll()
        	.anyRequest()
        	.permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // ALTHOUGH THIS SEEMS LIKE USELESS CODE,
        // IT'S REQUIRED TO PREVENT SPRING BOOT AUTO-CONFIGURATION
        return super.authenticationManagerBean();
    }
}
