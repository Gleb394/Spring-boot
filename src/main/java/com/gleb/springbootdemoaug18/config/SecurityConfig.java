package com.gleb.springbootdemoaug18.config;

import com.gleb.springbootdemoaug18.sevices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserServices userServices;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServices)
                .passwordEncoder(encoder);
 /*               .inMemoryAuthentication()
//                .passwordEncoder(encoder)
                .withUser("user")
                .password(encoder.encode("1234"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("1234"))
                .roles("USER", "ADMIN");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //вид атаки
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
