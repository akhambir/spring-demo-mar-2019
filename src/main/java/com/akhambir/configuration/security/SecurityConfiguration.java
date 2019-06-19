package com.akhambir.configuration.security;

import com.akhambir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuth(UserService userService, BCryptPasswordEncoder encoder) {
        DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
        daoAuth.setUserDetailsService(userService);
        daoAuth.setPasswordEncoder(encoder);
        return daoAuth;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/register", "/resources/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Autowired
    public void auth(UserService userService, AuthenticationManagerBuilder auth, DaoAuthenticationProvider daoAuth) throws Exception {
        auth.userDetailsService(userService);
        auth.authenticationProvider(daoAuth);
    }
}
