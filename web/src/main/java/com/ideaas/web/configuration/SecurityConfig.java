package com.ideaas.web.configuration;

import com.ideaas.services.service.UserDetailsServiceImpl;
import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public  UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());

        return authProvider;
    }

    @Autowired
    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/colaborador/**").hasAnyAuthority("ADMIN")
            .antMatchers("/evaluacion/**").hasAnyAuthority("ADMIN")
            .antMatchers("/evaluacionDelColaborador/**").hasAnyAuthority("ADMIN")
            .antMatchers("/puesto/**").hasAnyAuthority("ADMIN")
            .antMatchers("/sucursal/**").hasAnyAuthority("ADMIN")
            .antMatchers("/usuario/**").hasAnyAuthority("ADMIN")
            .antMatchers("/certificado/**").hasAnyAuthority("ADMIN", "COLABORADOR")
            .antMatchers("/assets/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .defaultSuccessUrl("/home")
            .loginPage("/login")
            .successHandler(authenticationSuccessHandler).permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
        ;


    }
}
