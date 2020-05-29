package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurity extends WebSecurityConfigurerAdapter
{
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 {
	        PasswordEncoder encoder = 
	          PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	          .password("password")
	          .roles("USER")
	          .and()
	          .withUser("admin")
	          .password("admin")
	          .roles("USER", "ADMIN");
	  }
	 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	          .authorizeRequests()
	          .antMatchers("/books/**").hasRole("USER")
	          .antMatchers("/authors/**").hasRole("ADMIN")
	          .antMatchers("/users/").permitAll()
	          .anyRequest()
	          .authenticated()
	          .and()
	          .formLogin()
	          .permitAll()
	          .and()
	          .logout();
	    }
}
