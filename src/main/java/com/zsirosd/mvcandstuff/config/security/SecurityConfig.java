package com.zsirosd.mvcandstuff.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.zsirosd.mvcandstuff.config.security.Roles.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void dummyAuthConfig(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    String encodedPassword = passwordEncoder().encode("dummyPassword");
    String username = "dummyUser";

    authenticationManagerBuilder
            .inMemoryAuthentication()
            .withUser(username).password(encodedPassword)
            .authorities(ROLE_USER);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
              .antMatchers("/", "/public/**").permitAll()
              .anyRequest().authenticated()
              .and()
            .formLogin()
              .permitAll()
              .and()
            .logout()
              .permitAll();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
