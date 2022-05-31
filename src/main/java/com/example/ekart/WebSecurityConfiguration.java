package com.example.ekart;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  //httpBasic() below would help us from getting Forbidden error for POST api.
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors().and().authorizeRequests()
        .antMatchers("/").permitAll()
//        .antMatchers(HttpMethod.POST,"*/add-to-cart/**").permitAll()
        .antMatchers(HttpMethod.GET, "/get-items/**").permitAll()
        .anyRequest().authenticated().and().httpBasic();
  }
}