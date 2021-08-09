package ru.nsu.sergomyaso.chatter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.nsu.sergomyaso.chatter.model.Role;
import ru.nsu.sergomyaso.chatter.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Access only for non-registered users
                .antMatchers("/registration").not().fullyAuthenticated()
                //Access only for users with the Administrator role
                .antMatchers("/admin/**").hasRole(Role.ROLE_ADMIN_TITLE)
                .antMatchers("/chat").hasRole(Role.ROLE_USER_TITLE)
                .antMatchers("/username").hasRole(Role.ROLE_USER_TITLE)
                //Access is allowed to all users
                //.antMatchers("/", "/resources/**").permitAll()
                //All other pages require authentication
                //.anyRequest().authenticated()
                .and()
                //Setting up for logging in
                .formLogin()
                .loginPage("/login")
                //Redirecting to the main page after a successful login
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}