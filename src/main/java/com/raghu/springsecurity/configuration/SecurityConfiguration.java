package com.raghu.springsecurity.configuration;

/*
@author raghu created on 10/10/2020 
inside the package -com.raghu.springsecurity.log
*/


import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    InitializingBean initializingBean(UserDetailsManager manager) {
        return () -> {
            UserDetails raghu = User.withDefaultPasswordEncoder().username("raghu").password("test").roles("USER").build();
            manager.createUser(raghu);
        };
    }

    @Bean
    UserDetailsManager userDetails(DataSource ds) {
        return new JdbcUserDetailsManager(ds);
    }


}
