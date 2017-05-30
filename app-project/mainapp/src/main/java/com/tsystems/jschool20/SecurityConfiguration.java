package com.tsystems.jschool20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by ruslbard on 17.04.2017.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {com.tsystems.jschool20.srvengine.services.security.UserDetailsServiceImpl.class})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/getAllRates").access("hasRole('CLIENT') or hasRole('OPERATOR')" )
                .antMatchers("/getAllOptions").access("hasRole('CLIENT') or hasRole('OPERATOR')" )
                .antMatchers("/getAllRateOptions").access("hasRole('CLIENT') or hasRole('OPERATOR')" )
                .antMatchers("/common/**").access("hasAuthority('ROLE_CLIENT')")
                .antMatchers("/operator/**").access("hasAuthority('ROLE_OPERATOR')")
                .antMatchers("/admin/**").access("hasAuthority('ROLE_ADMIN')")
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .defaultSuccessUrl("/", true)
                .and().logout().logoutUrl("/j_spring_security_logout")
                .logoutSuccessUrl("/login")
                .and().exceptionHandling().accessDeniedPage("/accessDeniedPage")
        ;

//        http.authorizeRequests()
//                .antMatchers("/showAllRatesForm").access("hasRole('OPERATOR')")
//                .and().formLogin().loginPage("/login")
//                .usernameParameter("ssoId").passwordParameter("password")
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
