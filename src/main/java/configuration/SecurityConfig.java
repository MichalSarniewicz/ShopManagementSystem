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

/**
 * This is a security config class, this class determines who is the user, what password and permissions he has.
 * 
 * @author Michał Sarniewicz
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 	/**
 	 * This class sets users and passwords
 	 * @param auth
 	 */
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
    
    /**
     * This class sets which parts of the system are secured and how.
     * @param http
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
    	.antMatchers("/css/**", "/h2_console/**")
    		.permitAll()
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
        	.httpBasic();
       
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    
    /**
     * This class is required to prevent spring boot auto-configuration
     * @exception
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

/*
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
	.antMatchers("/css/**", "/js/**", "/images/**", "/h2_console/**")
	.permitAll()
	.anyRequest()
	.permitAll();
http.csrf().disable();
http.headers().frameOptions().disable();
*/