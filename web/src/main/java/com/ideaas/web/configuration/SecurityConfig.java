package com.ideaas.web.configuration;

import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("usuarioService")
    private UsuarioService usuarioService;

    @Autowired
    @Qualifier("colaboradorService")
    private ColaboradorService colaboradorService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security.csrf().disable().
                authorizeRequests()
                .antMatchers("/MDB/**").permitAll()
                .antMatchers("/build/**").permitAll()
                .antMatchers("/data/**").permitAll()
                .antMatchers("/pages/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/usuario/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home", true);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(usuarioService).passwordEncoder(bcrypt);
        auth.userDetailsService(colaboradorService).passwordEncoder(bcrypt);

        auth.inMemoryAuthentication()
                .withUser("fede")
                .password("{noop}fede")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .credentialsExpired(true)
                .accountExpired(true)
                .accountLocked(true)
                .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
                .roles("MANAGER");
    }

}
